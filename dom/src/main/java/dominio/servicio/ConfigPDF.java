package dominio.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.value.Blob;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import com.google.common.io.Resources;

import dominio.dom.serv.OrdenServicioComputadora;

import org.apache.isis.applib.annotation.NatureOfService;


/*
 * Esta clase de servicio se utiliza para poder exportar los datos
 * de las tarjetas a formato pdf. La misma se utilizara desde cada tarjeta
 * danlo la opcion de descargar pdf
 */
@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY)
public class ConfigPDF
{
    private byte[] pdfAsBytes;
	    
    /*
     * Este metodo es en encargado de indicar cual es la plantilla
     * de referencia, donde luego se le cargaran los datos de la tarjeta 
     */
    @PostConstruct
    public void init() throws IOException {
        pdfAsBytes = Resources.toByteArray(Resources.getResource(this.getClass(), "salida.pdf"));
    }
    
    /*
     * Este metodo es el encargado de crear el documento de pdf, teniendo en cuenta
     * una plantilla anterior mente cargada. 
     * Y llamando al metodo loadAndPopulateTemplate
     */
    @MemberOrder(sequence = "10")
    public Blob descargarPDF(
            final OrdenServicioComputadora order) throws Exception {

        try (PDDocument pdfDocument = loadAndPopulateTemplate(order)) {

            final ByteArrayOutputStream target = new ByteArrayOutputStream();
            pdfDocument.save(target);
            final String name = "Orden-" + order.getId()+ ".pdf"; //nombre del archivo a descargar
            final String mimeType = "application/pdf";
            final byte[] bytes = target.toByteArray();

            return new Blob(name, mimeType, bytes);
        }
    }
    
    
    /*
     * Este metodo se encarga de incertar los datos de la tarjeta, en su correspondiente lugar
     * de la plantilla creada
     */
    @SuppressWarnings("unchecked")
    private PDDocument loadAndPopulateTemplate(OrdenServicioComputadora order) throws Exception {
        PDDocument pdfDocument = PDDocument.load(new ByteArrayInputStream(pdfAsBytes));
        PDAcroForm pdfForm = pdfDocument.getDocumentCatalog().getAcroForm();
		List<PDField> fields = pdfForm.getFields();
		String cables= "No";
		if(order.isCables()){
			cables="Si";
		}
		String pc= order.getComputadora().getId();
		String fecha= order.getFechaIngreso().toString();
		String causa= order.getCausa();
		String sector= order.getComputadora().getSector().getNombre();
		String tecnico = order.getTecnico().toString();
		
		
        for (PDField field : fields)
        {
			switch (field.getFullyQualifiedName())
			{
				case "txtId": field.setValue(order.getId());break;
				case "txtPc": field.setValue(pc);break;
				case "txtFecha": field.setValue(fecha);break;
				case "txtCausa": field.setValue(causa);break;
				case "txtSector": field.setValue(sector);break;
				case "txtTecnico": field.setValue(tecnico);break;
				case "txtCables": field.setValue(cables);break;				
				
				case "txtPc2": field.setValue(pc);break;
				case "txtFecha2": field.setValue(fecha);break;
				case "txtCausa2": field.setValue(causa);break;
				case "txtSector2": field.setValue(sector);break;
				case "txtTecnico2": field.setValue(tecnico);break;
				case "txtCables2": field.setValue(cables);break;		
			}

            				
        }
        return pdfDocument;
    }
}

    

