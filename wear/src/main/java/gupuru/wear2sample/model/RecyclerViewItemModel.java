package gupuru.wear2sample.model;

public class RecyclerViewItemModel {

    private int title;
    private int image;

    public RecyclerViewItemModel(int title, int image) {
        this.title = title;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public int getTitle() {
        return title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(int title) {
        this.title = title;
    }

}
