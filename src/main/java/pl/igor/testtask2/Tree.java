package pl.igor.testtask2;

abstract class Tree {

    protected int age = 0;

        double getStvolRadius(){
            return age * 1.2;
        };

        double getStvolVysota(){
            return age * 2;
        };

        int getVozrast(){
            return age;
        };
        abstract void rosti();

        abstract String getName();

}

class ListTree extends Tree{

    @Override
    public void rosti() {
        age++;
    }

    @Override
    public String getName() {
        return "list tree";
    }
}

class OtherTree extends Tree{

    @Override
    public void rosti() {
        age++;
    }

    @Override
    public String getName() {
        return "list tree";
    }
}
