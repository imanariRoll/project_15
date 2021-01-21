/**
 * Build a class that builds a Linked list to store large values.
 * The linked list will display the numbers from end to start.
 * 
 * 1) Will display from right to left to assure changes after decimal
 * are correct as possible
 * 
 * 2) Initialize list properly, including _head and getters and setters.
 * 
 * 
 *  // DID NOT COMPLETE YET! COMPLETE HEAD THEN CONSTRUCTORS // 
 * Steps to complete:
 * 
 * 1) Constructor that initializes the list to one element, containing '0'
 * 2) Constructor that receives long as param, stores it as linked list
 * 3) Copying constructor.
 * 4) Methods.

 * All of the methods must not change the caller or the param , but create a new bigNumber object and return it
 * as a solution.
 * 
 * MUST BE AS EFFICIENT AS POSSIBLE AT ALL TIMES
 * NOT ALLOWED TO USE ARRAYS
 * NOT ALLOWED TO CONVERT ELEMENT FROM LIST TO A INT, AND RETURN IT TO LIST AFTER PERFORMING ACTIONS ON.
 * 
 * 
 * PRIVATE METHODS ALLOWED!
 * 
 * REMEMBER! LINKED LIST EDGE CASES:
 * 
 * 1) What happens when the list is empty?
 * 2) What happens if the needed element is the first element?
 * 3) What happens if the needed element is the last element?
 * 
 * 
 * 
 */


public class BigNumber // acts as LinkedList class
{ // INTLIST INITIALISATION
    private IntNode _head;
    
    
    
    public BigNumber(IntNode node){
        _head = node;
    }
    
    public boolean isEmpty(){
        return (_head == null);
    }
    
    public void add(int value){
        IntNode node = new IntNode(value, null);
        if(isEmpty())
            _head = node;
        else{
            IntNode currentNode = _head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
        }
    }
    
    
    /**
     * Constructor for objects of class BigNumber as 
     * shown in the video
     */
    
    // Initializes to a list with single element containing '0'
    
    public BigNumber(){
     IntNode newNode = new IntNode(0, null);
     _head = newNode;
     
    }
    

    
    /**
     * 2) Constructor that receives long as param
     *  and stores it as a Linked list
     */
    public BigNumber(long number){
        long temp;
        IntNode lastNum;
        IntNode p; // pointer
        
        
        temp = number % 10;
        IntNode newNode = new IntNode((int)temp, null);
        _head = newNode; // starts the list officially.
        
        
      
        number = number / 10;
        
        
        while( number > 0 ){
            temp = number % 10; // receives second digit
            newNode = new IntNode((int)temp, _head); // creates second node
            
            number = number / 10;
            
            
            _head = newNode; // updating last num
            
        }
        
        
       
    }
    
    public BigNumber(BigNumber other){
        
        
        
        IntNode tempOther = other._head;
        this._head = new IntNode (0);
        IntNode tempThis = this._head;
        while (tempOther != null)
        {
            tempThis.setValue(tempOther.getValue());
            tempOther = tempOther.getNext(); 
            if (tempOther != null)
            {
                IntNode x1 = new IntNode (0); 
                tempThis.setNext(x1);
                tempThis = tempThis.getNext();
            }
        }

        BigNumber _numList = new BigNumber (this._head);
    
      /*  _head = other._head;
        BigNumber newList = new BigNumber(); // create a new head, and therefore list.
        
        IntNode p = new IntNode(other._head.getValue(),other._head.getNext());
        
        
       // newList._head.setValue(p.getValue());
       // newList._head.setNext(p.getNext());
        
        while(p != null){
            newList.add(p.getValue());
            
            p = p.getNext();
            
        } */
        
        
    }
    
   /* private IntNode BigNumber(IntNode list, IntNode newList){
        IntNode original;
        IntNode copy = newList;
        IntNode p = new IntNode(0, null);
     
        for(original = list; original !=null; original.getNext()){
            p.setValue(original.getValue());
            p.setNext(original.getNext());
            
            copy.setValue(p.getValue());
            copy.setNext(p.getNext());
            
            
            
        }
        if( original == null){ // Base case to exit
           return original;
        }
        
        BigNumber(original, copy);
        
        
        return copy;
    } */
    
    /**
     * toString method, must be O(n) while n is number
       *of numbers to print, must be recursion
 *      NOT ALLOWED TO CREATE MORE LISTS
 *      NOT ALLOWED TO USE ARRAYS
 *      NOT ALLOWED TO CONVERT LIST TO NUMBER
 *      
 *      RUNTIME-COMPLEXITY:
 *      MEMORY- COMPLEXITY:
     */
    public String toString(){ // MUST BE RECURSIVE.
        IntNode p =  this._head;
        
        if(p.getNext()  == null){
           return p.getValue() + "";   
        }
        
        
        return toString(p) ;
    }
    
    private String toString(IntNode x){ // recursive printing.
        int temp;
        while( x != null){
              temp = x.getValue();
              x = x.getNext();
              return temp + "" + toString(x);
        }
        
        return "" ;
    }
    
    /**
     * compareTo - if the number calling the method is smaller than param, return -1
     *             if the caller is larger than param, return 1, if equal return 0
     *             
     *  RUNTIME-COMPLEXITY:
 *      MEMORY- COMPLEXITY:
     */
    
    public int compareTo (BigNumber other){ // Might not work at all, needs to find access to getValue().
        int result = 0;
        IntNode p1 = _head;
        IntNode p2 = other._head;
        
        while(p1 != null && p2 != null){
           if(p1.getValue() < p2.getValue()){
             result = -1;
             
             
            }
            
           if(p1.getValue() > p2.getValue()){
               result = 1;
           }
            
          
           if(p1.getValue() == p2.getValue()){
               result = 0;
           }
           
           
           
           p1 = p1.getNext();
           p2 = p2.getNext();
            
           
        }
        
        if(p2 == null && p1 != null){ // count p2 as zero if it is null but p1 isnt
               if(p1.getValue() >= 0){ // if p1 is zero, they are equal
                  result = 1;
                }
               else{
                   result = 0;
                }
            }
            
        if( p1 == null && p2 != null){
            if(p2.getValue() >= 0){
                result = -1;
            }
            else{
                result = 0;
            }
            
        }
        
        
        
        return result;
    }
    
    /**
     * addBigNumber - addition between two elements, returns a new number as 
     * a bigNumber object.
     * 
     * RUNTIME-COMPLEXITY:
 *     MEMORY- COMPLEXITY:
     */
    
    public BigNumber addBigNumber (BigNumber other){
            BigNumber list = new BigNumber();
           if(_head != null || other._head != null){
                addBigNumber(_head, other._head);
                
            }
           
        
        return list;
    }
    
    private IntNode addBigNumber(IntNode p1, IntNode p2){
        IntNode newList = null; // headnode for the new list
        IntNode prev = null;
        IntNode temp = null;
        int carry = 0, sum;
        while(p1 != null || p2 != null){
            sum = carry + (p1 != null ? p1.getValue() : 0)
                  + (p2 != null ? p2.getValue() : 0);
            // Update carry for next calculation      
            carry = (sum >= 10) ? 1 : 0;
            
            // update sum if it is greater than 10
            sum = sum %10;
            
            // create new node with sum as data
            temp = new IntNode(sum);
            
            // if this is the first node then set
            // it as head of the new list
            
            if(newList == null){
               newList = temp;
            }
            
            // if this is not the first node then set
            // it to connect to the rest
            
            else{
                prev.setNext(temp);
            }
            
            // set prev for next insertion
            prev = temp;
            
            // move the first and second pointers to next nodes
            if( p1 != null) {
                p1 = p1.getNext();
            }
            if( p2 != null){
                p2 = p2.getNext();
            }
           
            
        }
        
        if( carry > 0){
            IntNode tempCarry = new IntNode(carry);
            temp.setNext(tempCarry);
        }
        
        return newList;
        
    }
    
    
    /**
     * addLong - addition between bigNumber object and long, returns a bigNumber object.
     * 
     * RUNTIME-COMPLEXITY:
 *     MEMORY- COMPLEXITY:
     */
    
    public BigNumber addLong (long num){
        BigNumber otherList = new BigNumber(num);
      
        if(_head != null || otherList._head != null){
               addBigNumber(otherList);
               
            }
            return otherList;
        }
        
        private IntNode addLong(IntNode p1, IntNode p2){
        /* ============= CALCULCATING THE SUM ========== */
        
        IntNode newList = null; // headnode for the new list
        IntNode prev = null;
        IntNode temp = null;
        int carry = 0, sum;
        while(p1 != null || p2 != null){
            sum =  (p1 != null ? p1.getValue() : 0) // get value if not null, if its false return zero.
                  + (p2 != null ? p2.getValue() : 0);
            // Update carry for next calculation      
            carry =  (sum >= 10) ? 1 : 0;
            
            // update sum if it is greater than 10
            sum = sum %10;
            
            // create new node with sum as data
            temp = new IntNode(sum);
            
            
            
            
            if( carry > 0 && newList == null){
                IntNode carryNode = new IntNode(carry);
                carryNode.setNext(temp);
                newList = carryNode;
            }
            
            if(carry > 0 && prev != null){
                prev.setValue(prev.getValue() + carry);
            }
            
            if(prev != null && p2 !=null ){
                prev.setNext(temp);
                
            }
            
            // set prev for next insertion
            prev = temp;
            newList = prev;
            
            // move the first and second pointers to next nodes
            if( p1 != null) {
                p1 = p1.getNext();
            }
            if( p2 != null){
                p2 = p2.getNext();
            }
           
            
        }
        
        if( carry > 0){
            IntNode tempCarry = new IntNode(carry);
            temp.setNext(tempCarry);
        }
        
        
        return newList; }
    /**
     * subtractBigNumber - subtraction between two bigNumber objects. You must check which one is bigger
     * and subtract the smaller value from it, retruns a bigNumber object.
     * 
     * RUNTIME-COMPLEXITY:
 *     MEMORY- COMPLEXITY:
     */
    
    public BigNumber subtractBigNumber (BigNumber other){
        return null;
    }
    /**
     * multBigNumber - multiplication between two bigNumber objects. returns a bigNumber object.
     * 
     * RUNTIME-COMPLEXITY: O(n^2) OR n * M
 *     MEMORY- COMPLEXITY:
     */
    
    public BigNumber multBigNumber (BigNumber other){
        return null;
    }

    
    
}
