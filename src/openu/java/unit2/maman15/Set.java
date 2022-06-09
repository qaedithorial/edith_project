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
        IntNode current = _head;
        while (current != null)
        {
            if (current.getValue() == num)
            {
                return true;
            }

            current = current.getNext();
        }
        return false;
    }

    // time complexity - O(n)
    // space complexity - O(1)
    //TODO ADD API
    public boolean equals(Set other)
    {
        IntNode current = this._head;
        IntNode currentOther = other._head;
        while (current != null && currentOther != null)
        {
            if (current.getValue() != currentOther.getValue())
            {
                return false;
            }
            current = current.getNext();
            currentOther = currentOther.getNext();
        }

        if (current == null && currentOther == null)
        {
            return true;
        }

        return false;
    }

    public int numOfElements()
    {
        int count = 0;

        IntNode curr = _head;
        while (curr != null)
        {
            count++;
            curr = curr.getNext();
        }

        return count;
    }

    public boolean subSet(Set other)
    {
        IntNode curr = _head;
        IntNode curr2 = other._head;
        while (curr != null && curr2 != null)
        {
            if (curr.getValue() > curr2.getValue())
            {
                return false;
            }
            if (curr.getValue() == curr2.getValue())
            {
                curr = curr.getNext();
                curr2 = curr2.getNext();
            }
            else
            {
                curr = curr.getNext();
            }
        }

        return curr2 == null;

    }

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
            IntNode curr = _head;
            while (curr.getNext() != null)
            {

                if (curr.getValue() == x)
                {
                    return;
                }
                if (x < curr.getNext().getValue())
                {
                    // IntNode newNode = new IntNode(x, curr.getNext());
                    // curr.setNext(newNode);
                    curr.setNext(new IntNode(x, curr.getNext()));
                    return;
                }
                curr = curr.getNext();
            }

            curr.setNext(new IntNode(x, null));

        }
    }

    public void removeFromSet(int x)
    {
        if (_head == null)
        {
            return;
        }
        IntNode curr = _head;
        while (curr.getNext() != null)
        {
            if (curr.getNext().getValue() == x)
            {
                IntNode newNext = curr.getNext().getNext();
                curr.getNext().setNext(null);
                curr.setNext(newNext);
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }

    public String toString()
    {
        String str = "{";

        IntNode curr = _head;
        while (curr != null)
        {
            str += curr.getValue() + (curr.getNext() != null ? "," : "");
            curr = curr.getNext();
        }

        return str + "}";
    }

    public Set intersection(Set other)
    {
        Set set = new Set();
        IntNode curr = _head;
        IntNode curr2 = other._head;
        while (curr != null && curr2 != null)
        {
            if (curr.getValue() > curr2.getValue())
            {
                curr2 = curr2.getNext();
            }
            else
            {
                if (curr.getValue() == curr2.getValue())
                {
                    set.addToSet(curr.getValue());
                    curr2 = curr2.getNext();
                    curr = curr.getNext();
                }
                else
                {
                    curr = curr.getNext();
                }
            }
        }

        return set;

    }

    public Set union(Set other)
    {
        Set unionSet = new Set();
        IntNode currUnion = null;
        IntNode curr = _head;
        IntNode curr2 = other._head;
        while (curr != null && curr2 != null)
        {
            if (curr.getValue() < curr2.getValue())
            {
                if (currUnion == null)
                {
                    currUnion = unionSet._head = new IntNode(curr.getValue(), null);
                    // set._head = new IntNode(curr.getValue(), null);
                    // currUnion = set._head;
                }
                else
                {
                    currUnion.setNext(new IntNode(curr.getValue(), null));
                    currUnion = currUnion.getNext();
                }

                curr = curr.getNext();
            }
            else
            {
                if (curr.getValue() > curr2.getValue())
                {
                    if (currUnion == null)
                    {
                        currUnion = unionSet._head = new IntNode(curr2.getValue(), null);
                        // set._head = new IntNode(curr.getValue(), null);
                        // currUnion = set._head;
                    }
                    else
                    {
                        currUnion.setNext(new IntNode(curr2.getValue(), null));
                        currUnion = currUnion.getNext();
                    }

                    curr2 = curr2.getNext();
                }
                else
                {
                    if (currUnion == null)
                    {
                        currUnion = unionSet._head = new IntNode(curr2.getValue(), null);
                    }
                    else
                    {
                        currUnion.setNext(new IntNode(curr2.getValue(), null));
                        currUnion = currUnion.getNext();
                    }
                    curr = curr.getNext();
                    curr2 = curr2.getNext();
                }
            }
        }

        while (curr != null)
        {
            if (currUnion == null)
            {
                currUnion = unionSet._head = new IntNode(curr.getValue(), null);
                // set._head = new IntNode(curr.getValue(), null);
                // currUnion = set._head;
            }
            else
            {
                currUnion.setNext(new IntNode(curr.getValue(), null));
                currUnion = currUnion.getNext();
            }

            curr = curr.getNext();

        }

        while (curr2 != null)
        {
            if (currUnion == null)
            {
                currUnion = unionSet._head = new IntNode(curr2.getValue(), null);
                // set._head = new IntNode(curr.getValue(), null);
                // currUnion = set._head;
            }
            else
            {
                currUnion.setNext(new IntNode(curr2.getValue(), null));
                currUnion = currUnion.getNext();
            }

            curr2 = curr2.getNext();

        }

        return unionSet;
    }

    public Set difference(Set other)
    {
        Set diffSet = new Set();
        IntNode diffTail = null;
        IntNode curr = _head;
        IntNode curr2 = other._head;
        while (curr != null && curr2 != null)
        {
            if (curr.getValue() < curr2.getValue())
            {
                if (diffSet._head == null)
                {
                    diffTail = diffSet._head = new IntNode(curr.getValue(), null);
                }
                else
                {
                    diffTail.setNext(new IntNode(curr.getValue(), null));
                    diffTail = diffTail.getNext();
                }

                curr = curr.getNext();
            }
            else
            {
                if (curr.getValue() > curr2.getValue())
                {
                    curr2 = curr2.getNext();
                }
                else
                {
                    curr = curr.getNext();
                    curr2 = curr2.getNext();
                }
            }
        }

        while (curr != null)
        {
            diffTail.setNext(new IntNode(curr.getValue(), null));
            diffTail = diffTail.getNext();
            curr = curr.getNext();
        }
        return diffSet;
    }
}
