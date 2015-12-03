import java.util.NoSuchElementException;

// dllist.java
// Template code for doubly-linked list of strings.

public class dllist {

   public enum position {FIRST, PREVIOUS, FOLLOWING, LAST};

   private class node {
      String item;
      node prev;
      node next;
   }

   private node first = null;
   private node current = null;
   private node last = null;
   private int currentPosition = 0;
   private int numOfElems = 0;

   public void setPosition (position pos) {
      //throw new UnsupportedOperationException();
	   if(pos.equals(position.FIRST)){
		   current = first;
		   System.out.println(current.item);
	   }else if(pos.equals(position.PREVIOUS)){
		   current = current.prev;
		   System.out.println(current.item);
	   }else if(pos.equals(position.FOLLOWING)){
		   current = current.next;
		   System.out.println(current.item);
	   }else{
		   current = last;
		   System.out.println(last.prev.item);
	   }
   }

   public boolean isEmpty () {
      if(first == null && last == null & numOfElems == 0)
    	  return true;
      else
    	  return false;
   }

   public String getItem () {
      //throw new UnsupportedOperationException();
	   return current.item;
   }

   public int getPosition () {
      //throw new UnsupportedOperationException();
      if(currentPosition == 0){
    	  throw new NoSuchElementException();
      }else{
    	  return currentPosition;
      }
   }

   public void delete () {
      //throw new UnsupportedOperationException();
	   if(numOfElems == 0){
		   throw new NoSuchElementException();
	   }
	   current.prev.next = current.next;
	   current = current.next;
	   current.prev = current.prev.prev;
	   numOfElems--;
   }

   public void insert (String item, position pos) {
      //throw new UnsupportedOperationException();
	   if(isEmpty()){
		   first = new node();
		   first.item = item;
		   first.next = null;
		   first.prev = null;
		   last = first;
		   current = first;
		   currentPosition++;
		   numOfElems++;
	   }else if(pos == position.FIRST){
		   node n = new node();
		   n.item = item;
		   n.prev = first.prev;
		   n.next = first;
		   first.prev = n;
		   currentPosition = 0;
		   numOfElems++;
		   current = n;
	   }else if(pos == position.PREVIOUS){
		   node n = new node();
		   n.item = item;
		   n.prev = current.prev;
		   n.next = current;
		   current = n;
		   currentPosition--;
		   numOfElems++;
	   }else if(pos == position.FOLLOWING){
		   node n = new node();
		   if(current == first){
			   n.item = item;
			   n.prev = first.prev;
			   n.next = first;
			   first.prev = n;
			   currentPosition = 0;
			   numOfElems++;
			   current = n;
			   return;
		   }else if(currentPosition == numOfElems-1){
			   n.item = item;
			   //
		   }
		   n.item = item;
		   n.prev = current;
		   n.next = current.next;
		   
//		   node n = new node();
//		   n.item = item;
//		   n.prev = current;
//		   n.next = current.next;
//		   if(current.equals(last)){
//			   last = n;
//			   n.next = null;
//		   }
//		   
//		   current = n;
//		   currentPosition++;
//		   numOfElems++;
	   }else if(pos == position.LAST){
		   node n = new node();
		   n.item = item;
		   n.prev = last;
		   n.next = null;
		   last = n;
		   current = n;
		   numOfElems++;
		   currentPosition = numOfElems - 1;
	   }
	   
   }
   
   public position getFirst(){
	   return position.FIRST;
   }
   
   public position getPrevious(){
	   return position.PREVIOUS;
   }
   
   public position getFollowing(){
	   return position.FOLLOWING;
   }
   
   public position getLast(){
	   return position.LAST;
   }
   

}

