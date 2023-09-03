package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._01_builder.sda.exercise;

public class Block {

    private final String name;
    private final String shape;
    private final Color color;
    private final Integer penWidth;

    public String getName() {
        return name;
    }

    public String getShape() {
        return shape == null ? "" : shape;
    }

    public Color getColor() {
        return color == null ? Color.WHITE : color;
    }

    public Integer getPenWidth() {
        return penWidth == null ? 0 : penWidth;
    }

    @Override
    public String toString() {
        return "Block= " + this.getName()
                + ", Shape= " + this.getShape()
                + ", Color=" + this.getColor()
                + ", Pen Width= " + getPenWidth();
    }

    private Block(BlockBuilder builder) {
        this.name = builder.name;
        this.shape = builder.shape;
        this.color = builder.color;
        this.penWidth = builder.penWidth;
    }

    public static class BlockBuilder {

        private String name;

        private String shape;
        private Color color;
        private Integer penWidth;

        public BlockBuilder(String name) {
            this.name = name;
        }

        public BlockBuilder setShape(String shape) {
            this.shape = shape;
            return this;
        }

        public BlockBuilder setColor(Color color) {
            this.color = color;
            return this;
        }

        public BlockBuilder setPenWidth(Integer penWidth) {
            this.penWidth = penWidth;
            return this;
        }

        public Block build() {
            return new Block(this);
        }
    }
}

enum Color {WHITE}
