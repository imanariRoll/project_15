public BigNumber addLong (long num){
        long x = num;
        
        IntNode p;
        IntNode prev;
        BigNumber list =new BigNumber();
        for(p = this._head; p.getNext() !=null; p = p.getNext()); // makes sure p is the last pointer
        if(p.getNext() == null)
        {
            prev = null;
        }
        else
        {
            for(prev = this._head; prev.getNext().getNext() != null; prev = prev.getNext()); // previous pointer.
        }
        
        // ONLY DO THIS ONE TIME:
        IntNode temp = new IntNode(0,null); // new node created.
        long digit = x % 10;
        temp.setValue(((int)digit + p.getValue())); // result of sum, last node of new linked list
                if( list != null && prev != null){
                prev.setNext(temp);
                
                }
                
                
        list._head.setValue(temp.getValue()); // head of list is updated to updated values of temp.
        list._head.setNext(temp);
        prev = temp; // prev is now pointing at list head.
        while( x > 0)
        { 
            temp = new IntNode(0,null); // new node created.
            digit = x % 10;
            temp.setValue(((int)digit + p.getValue())); // result of sum, last node of new linked list
            prev.setNext(temp); // prev is now pointing at list head.
                
            // ==== update values ==== //
            if(prev != null)
            {
                p = prev; // p points to prev.
                prev.setNext(null); // prev is now last element.
            }
            
            x = x / 10; // num is updated.
            
            
            
            
        }
        return list;
        }
