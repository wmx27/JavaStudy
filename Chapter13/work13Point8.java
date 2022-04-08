package Chapter13;

import java.util.ArrayList;

public class work13Point8 implements Cloneable{
    private ArrayList<Object> list =new ArrayList<>();
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int getSize(){
        return list.size();
    }
    public Object peek(){

        return list.get(getSize()-1);
    }
    public Object pop(){
        Object o=list.get(getSize()-1);
        list.remove(getSize()-1);
        return o;
    }
    public void push(Object o){
        list.add(o);
    }
    @Override
    public String toString(){
        return "stack: "+list.toString();
    }
    @Override
    public Object clone(){
        Object o = null;
        try {
            o = (work13Point8) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return o;
    }

    public static void main(String[] args) {
        work13Point8 stack=new work13Point8();
        stack.push(new Double(1.5));
        work13Point8 stack2 = (work13Point8) stack.clone();
        System.out.println(stack==stack2);
        System.out.println(stack.peek()==stack2.peek());
    }

}
