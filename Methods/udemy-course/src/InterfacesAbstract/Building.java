package InterfacesAbstract;

public class Building implements Mappable{

    private String name;
    private BuildingType buildingType;

    public Building(String name, BuildingType buildingType) {
        this.name = name;
        this.buildingType = buildingType;
    }

    @Override
    public String getLabel() {
        return """
                %s -> %s
                """.formatted(this.name, this.buildingType);
    }

    @Override
    public String getMarker() {
        return switch (buildingType){
            case BUSINESS -> Markers.CIRCLE.toString();
            case RESIDENTIAL -> Markers.SQUARE.toString();
        };
    }

    @Override
    public Geomtery getGeometry() {
        return Geomtery.POINT;
    }
}
