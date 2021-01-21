public BigNumber addLong (long num){
        BigNumber list = new BigNumber(num);
        long number = num;
        int length1=0;
        int length2=0;
        int index = 0;
        int countLength = 0;
        
        IntNode p;
        IntNode p2;
        IntNode prev;
        
        for(p = this._head; p.getNext() !=null; p = p.getNext()){
            length1++;
        }
        for(p2 = list._head; p.getNext() !=null; p2 = p2.getNext())
        {
            length2++;
        }
        if( length1 > length2){
        countLength = length1 - length2;
        }
        else{
            countLength = length2 - length1;
            
        }
        
        while(number > 0){
            IntNode indexP = p;
            
            if(index > countLength)
            {
              p.setValue(p.getValue() + p2.getValue());  
            }
            
        }
        
        return list;
        }
