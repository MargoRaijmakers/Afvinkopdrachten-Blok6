public class Gene implements Comparable <Gene>{

    private String geneId;
    private String symbol;
    private String chromosome;
    private char arm;
    private String mapLocation;

    public Gene(String geneId, String symbol, String chromosome, char arm, String mapLocation) {
        this.geneId = geneId;
        this.symbol = symbol;
        this.chromosome = chromosome;
        this.arm = arm;
        this.mapLocation = mapLocation;
    }

    public int compareTo(Gene g){
        try {
            int x = Integer.compare(Integer.parseInt(this.getChromosome()), Integer.parseInt(g.getChromosome()));
            if (x != 0){
                return x;
            }
            return Float.compare(Float.parseFloat(this.getMapLocation()), Float.parseFloat(g.getMapLocation()));
        } catch (NumberFormatException nfe) {
            int x = Character.compare(this.getChromosome().charAt(0), g.getChromosome().charAt(0));
            if (x != 0) {
                return x;
            }
            return Float.compare(Float.parseFloat(this.getMapLocation()), Float.parseFloat(g.getMapLocation()));
        }
    }

    public String toString(){
        return "Symbool: "+symbol+", gene id: "+geneId+", chromosoom: "+ chromosome+", arm: "+arm+
                ", locatie: "+mapLocation;
    }

    public String getGeneId() {
        return geneId;
    }

    public void setGeneId(String geneId) {
        this.geneId = geneId;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public char getArm() {
        return arm;
    }

    public void setArm(char arm) {
        this.arm = arm;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
