package dominio.dom.serv;

public enum Tecnicos 
{	
	NicolasCuevas
	{
        @Override
        public List<String> subcategories() {
            return Arrays.asList(null, Subcategory.OPEN_SOURCE, Subcategory.CONSULTING, Subcategory.EDUCATION, Subcategory.MARKETING);
        }
    }, GabrielSoto
}
