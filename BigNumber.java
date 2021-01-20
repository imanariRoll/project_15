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
{
    static IntNode _head;
    int val;
    IntNode next;
    
    
    /**
     * Constructor for objects of class BigNumber as 
     * shown in the video
     */
    
    // Initializes to a list with single element containing '0'
    
    public BigNumber(){
     IntNode newNode = new IntNode(0, null);
     _head = newNode;
     
    }
    
    public BigNumber(int val, IntNode next){this.val =val; this.next = next; }
    
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
        lastNum = newNode; // points at newNode.
        
      
        number = number / 10;
        
        
        while( number > 0 ){
            temp = number % 10; // receives second digit
            newNode = new IntNode((int)temp, lastNum); // creates second node
            
            number = number / 10;
            
            
            lastNum = newNode; // updating last num
            
        }
        
        _head = lastNum;
        
       
       
    }
    
    public BigNumber(BigNumber other){ // needs to copy an entire linked list
        _head = other._head;
        
    }
    
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
              return temp + " " + toString(x);
        }
        
        return " " ;
    }
    
    /**
     * compareTo - if the number calling the method is smaller than param, return -1
     *             if the caller is larger than param, return 1, if equal return 0
     *             
     *  RUNTIME-COMPLEXITY:
 *      MEMORY- COMPLEXITY:
     */
    
    public int compareTo (BigNumber other){ // Might not work at all, needs to find access to getValue().
        if(this.val < other.val){
            return -1;
        }
        if(this.val > other.val){
          return 1;   
        }
        
        return 0;
    }
    
    /**
     * addBigNumber - addition between two elements, returns a new number as 
     * a bigNumber object.
     * 
     * RUNTIME-COMPLEXITY:
 *     MEMORY- COMPLEXITY:
     */
    
    public BigNumber addBigNumber (BigNumber other){
           if(_head != null || other._head != null){
               addBigNumber(_head, other._head);
            }
           
        
        return null;
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
        BigNumber toAdd = new BigNumber(num); // creates the _head for the new list.
        IntNode p = _head;
        
        
        
        
        
        if(_head != null){
          while( p.getNext() != null){
             p = p.getNext(); 
            }
            
          
        }
        return null;
    }
