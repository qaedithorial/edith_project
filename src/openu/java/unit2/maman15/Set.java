package openu.java.unit2.maman15;

/**
 * This class represent infinite odd numbers as int for example: {1,3,5,7,...}.
 * @author Edith Kamkhaji
 * @version v.0.0.1
 */


public class Set {
    // instance variables
    private IntNode _head;

    // In order to maintain efficiency I will use sorting lists.
    // it will be done by adding the parameter (number) in it exact place in the list


    // time complexity: O(1)
    // space complexity: O(1)
    /**
     *  checks if the node is empty
     * @return _head == null
     */
    public boolean isEmpty()
    {
        return _head == null;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    /**
     *  checks if a number appears in the set.
     * @param num - the method will get a number and will check if it is in the set
     * @return true/false according to the num appearance.
     */
    public boolean isMember(int num)
    {
        IntNode currrentent = _head;
        while (currrentent != null)
        {
            if (currrentent.getValue() == num)
            {
                return true;
            }

            currrentent = currrentent.getNext();
        }
        return false;
    }

    // time complexity - O(n)
    // space complexity - O(1)
    /**
     *  checks if object's group equals to others' group.
     * @param other - the method will get a number and will check if it is in the set
     * @return true if group in other equals to group in object, else returns false.
     */
    public boolean equals(Set other)
    {
        IntNode currrentent = this._head;
        IntNode currrententOther = other._head;
        while (currrentent != null && currrententOther != null)
        {
            if (currrentent.getValue() != currrententOther.getValue())
            {
                return false;
            }
            currrentent = currrentent.getNext();
            currrententOther = currrententOther.getNext();
        }

        if (currrentent == null && currrententOther == null)
        {
            return true;
        }

        return false;
    }


    // time complexity - O(n)
    // space complexity - O(1)
    /**
     *  checks how much elements in a group.
     * @return number of elements in a group.
     */
    public int numOfElements()
    {
        int count = 0;

        IntNode currrent = _head;
        while (currrent != null)
        {
            count++;
            currrent = currrent.getNext();
        }

        return count;
    }
    
    // time complexity - O(n)
    // space complexity - O(1)
    /**
     *  checks if group in other is a subset of an object's group.
     * @param other - of type Set
     * @return true if group in other is a subset of a group in object, else returns false.
     */
    public boolean subSet(Set other)
    {
        IntNode currrent = _head;
        IntNode currrentrentOther = other._head;
        while (currrent != null && currrentrentOther != null)
        {
            if (currrent.getValue() > currrentrentOther.getValue())
            {
                return false;
            }
            if (currrent.getValue() == currrentrentOther.getValue())
            {
                currrent = currrent.getNext();
                currrentrentOther = currrentrentOther.getNext();
            }
            else
            {
                currrent = currrent.getNext();
            }
        }

        return currrentrentOther == null;

    }
    
    // time complexity - O(n)
    // space complexity - O(1)
    /**
     *  checks if object's group equals to others' group.
     * @param x - type int
     */
    public void addToSet(int x)
    {
        if (x % 2 == 0 || x < 0)
        {
            return;
        }

        if (_head == null || _head.getValue() > x)
        {
            _head = new IntNode(x, _head);
        }
        else
        {
            IntNode currrent = _head;
            while (currrent.getNext() != null)
            {

                if (currrent.getValue() == x)
                {
                    return;
                }
                if (x < currrent.getNext().getValue())
                {
                    // IntNode newNode = new IntNode(x, currrent.getNext());
                    // currrent.setNext(newNode);
                    currrent.setNext(new IntNode(x, currrent.getNext()));
                    return;
                }
                currrent = currrent.getNext();
            }

            currrent.setNext(new IntNode(x, null));

        }
    }
    
    // time complexity: O(n)
    // space complexity: O(1)
    /**
     *  gets an int and removes it from the group.
     * @param x - type int
     */
    public void removeFromSet(int x)
    {
        if (_head == null)
        {
            return;
        }
        IntNode currrent = _head;
		    IntNode prev = null;
		    while (currrent != null)
		    {
			    if (currrent.getValue() == x)
			    {
				    if (prev == null)
				  {
					  _head = _head.getNext();
					  return;
				  }
				  prev.setNext(currrent.getNext());
				  return;
			  }
      }
      prev = currrent;
      currrent = currrent.getNext();
    }

    // time complexity: O(n)
    // space complexity: O(n)
    /**
     *  checks if object's group equals to others' group.
     * @return  returns elements in a group in list format: {a1,a2,a3}.
     */
    public String toString()
    {
        String str = "{";

        IntNode currrent = _head;
        while (currrent != null)
        {
            str += currrent.getValue() + (currrent.getNext() != null ? "," : "");
            currrent = currrent.getNext();
        }

        return str + "}";
    }
    
    // time complexity: O(n)
    // space complexity: O(n)
    /**
     *  func will create new group that contain both other cutting group and object group but will not
     *  change nigher group.
     * @param other - type Set
     * @return new group containing other cutting group with object group .
     */
    public Set intersection(Set other)
    {
        Set set = new Set();
        IntNode currrent = _head;
        IntNode currrentrentOther = other._head;
        while (currrent != null && currrentrentOther != null)
        {
            if (currrent.getValue() > currrentrentOther.getValue())
            {
                currrentrentOther = currrentrentOther.getNext();
            }
            else
            {
                if (currrent.getValue() == currrentrentOther.getValue())
                {
                    set.addToSet(currrent.getValue());
                    currrentrentOther = currrentrentOther.getNext();
                    currrent = currrent.getNext();
                }
                else
                {
                    currrent = currrent.getNext();
                }
            }
        }

        return set;

    }
    
    // time complexity: O(n)
    // space complexity: O(n)
    /**
     *  will create new union group that contains other group and the group that was activated.
     * @param other - type Set
     * @return new union group
     */
    public Set union(Set other)
    {
        Set unionSet = new Set();
        IntNode currrentUnion = null;
        IntNode currrent = _head;
        IntNode currrentrentOther = other._head;
        while (currrent != null && currrentrentOther != null)
        {
            if (currrent.getValue() < currrentrentOther.getValue())
            {
                if (currrentUnion == null)
                {
                    currrentUnion = unionSet._head = new IntNode(currrent.getValue(), null);
                }
                else
                {
                    currrentUnion.setNext(new IntNode(currrent.getValue(), null));
                    currrentUnion = currrentUnion.getNext();
                }

                currrent = currrent.getNext();
            }
            else
            {
                if (currrent.getValue() > currrentrentOther.getValue())
                {
                    if (currrentUnion == null)
                    {
                        currrentUnion = unionSet._head = new IntNode(currrentrentOther.getValue(), null);
                    }
                    else
                    {
                        currrentUnion.setNext(new IntNode(currrentrentOther.getValue(), null));
                        currrentUnion = currrentUnion.getNext();
                    }

                    currrentrentOther = currrentrentOther.getNext();
                }
                else
                {
                    if (currrentUnion == null)
                    {
                        currrentUnion = unionSet._head = new IntNode(currrentrentOther.getValue(), null);
                    }
                    else
                    {
                        currrentUnion.setNext(new IntNode(currrentrentOther.getValue(), null));
                        currrentUnion = currrentUnion.getNext();
                    }
                    currrent = currrent.getNext();
                    currrentrentOther = currrentrentOther.getNext();
                }
            }
        }

        while (currrent != null)
        {
            if (currrentUnion == null)
            {
                currrentUnion = unionSet._head = new IntNode(currrent.getValue(), null);
            }
            else
            {
                currrentUnion.setNext(new IntNode(currrent.getValue(), null));
                currrentUnion = currrentUnion.getNext();
            }

            currrent = currrent.getNext();

        }

        while (currrentrentOther != null)
        {
            if (currrentUnion == null)
            {
                currrentUnion = unionSet._head = new IntNode(currrentrentOther.getValue(), null);
            }
            else
            {
                currrentUnion.setNext(new IntNode(currrentrentOther.getValue(), null));
                currrentUnion = currrentUnion.getNext();
            }

            currrentrentOther = currrentrentOther.getNext();

        }

        return unionSet;
    }
    
    // time complexity: O(n)
    // space complexity: O(n)
    /**
     * @param other - of type Set
     * @return new group that represent the diffference betrween other union group and with the group in object .
     */
    public Set difference(Set other)
    {
        Set diffSet = new Set();
        IntNode diffTail = null;
        IntNode currrent = _head;
        IntNode currrentrentOther = other._head;
        while (currrent != null && currrentrentOther != null)
        {
            if (currrent.getValue() < currrentrentOther.getValue())
            {
                if (diffSet._head == null)
                {
                    diffTail = diffSet._head = new IntNode(currrent.getValue(), null);
                }
                else
                {
                    diffTail.setNext(new IntNode(currrent.getValue(), null));
                    diffTail = diffTail.getNext();
                }

                currrent = currrent.getNext();
            }
            else
            {
                if (currrent.getValue() > currrentrentOther.getValue())
                {
                    currrentrentOther = currrentrentOther.getNext();
                }
                else
                {
                    currrent = currrent.getNext();
                    currrentrentOther = currrentrentOther.getNext();
                }
            }
        }

        while (currrent != null)
        {
            diffTail.setNext(new IntNode(currrent.getValue(), null));
            diffTail = diffTail.getNext();
            currrent = currrent.getNext();
        }
        return diffSet;
    }
}
