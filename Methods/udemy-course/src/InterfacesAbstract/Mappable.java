package InterfacesAbstract;


public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s}
            """;

    //return label - how item will be described
    String getLabel();

    //return geometry type (Point or Line)
    Geomtery getGeometry();

    //Icon Type
    String getMarker();


    default String toJSON(){
        return """
                "geometry type": %s, "label": %s, "marker": %s
                """.formatted(getGeometry(), getLabel(), getMarker());
    }

    static void printType(Mappable mappable){
        System.out.printf((JSON_PROPERTY) + "%n", mappable.toJSON());
    }
}
