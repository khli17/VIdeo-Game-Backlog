class Game{
    String name;

    double hours;

    String status; 

    public Game(String name, double hours, String status){
        this.name = name;
        this.hours = hours;
        this.status = status;
    }

    public void setName(String name){
        this.name = name; 
    }

    public void setHours(double hours){
        this.hours = hours;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getName(){
        return this.name;
    }

    public double getHours(){
        return hours;
    }

    public String getStatus(){
        return status;
    }
}