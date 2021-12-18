package entities;

public class CircularList<T> {

    private Node<T> headNode;
    private Node<T> tailNode;
    private int listSize;

    public int size() {
        return this.listSize;
    }

    public CircularList() {
        this.tailNode = null;
        this.headNode = null;
        this.listSize = 0;
    }

    public boolean isEmpty() {
        return this.listSize == 0 ? true : false;
    }

    public Node<T> getNode(int index){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("This List is Empty!");
        }
        if (index == 0){
            return this.tailNode;
        }else{
            Node<T> auxNode = tailNode;
            for (int i = 0; i < index; i++){
                auxNode = auxNode.getNextNode();
            }
            return auxNode;
        }
    }

    public T get(int index){
        return this.getNode(index).getData();
    }

    public void remove(int index){
        if(index > this.listSize){
            throw new IndexOutOfBoundsException("The given index ie greater than list size!");
        }else{
            Node<T> auxNode = this.tailNode;
            if (index == 0){
                this.tailNode = this.tailNode.getNextNode();
                this.headNode.setNextNode(this.tailNode);
            }else if(index == 1){
                this.tailNode.setNextNode(this.tailNode.getNextNode().getNextNode());
            }else{
                for (int i = 0; i < index-1; i++){
                    auxNode = auxNode.getNextNode();
                }
                auxNode.setNextNode(auxNode.getNextNode().getNextNode());
            }
        }
        this.listSize--;
        }

        public void add(T data){
        Node<T> newNode = new Node<T>(data);
        if (this.listSize == 0){
            this.headNode = newNode;
            this.tailNode = newNode;
            this.headNode.setNextNode(tailNode);
        }else{
            newNode.setNextNode(this.tailNode);
            this.headNode.setNextNode(newNode);
            this.tailNode =newNode;
        }
        this.listSize ++;
    }

    @Override
    public String toString() {
        String returnString = "";
        Node<T> auxNode = this.tailNode;
        for (int i =0; i < listSize; i++){
            returnString += "[Node{data=" + auxNode.getData() + "}]--->";
            auxNode = auxNode.getNextNode();
        }
        returnString += this.size() != 0 ? "(back to begining)" : "[]";

        return returnString;
    }
}
