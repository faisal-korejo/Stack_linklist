

public class SingleLinkedList {
    static int size;

    private class node{
      Object data;
      node next;

      node(Object data) {
          this.data=data;
           size=0;
      }
    }

    public void traverse(node head){
        if(head==null)
            return;
        for(node temp=head;temp!=null;temp=temp.next){
            System.out.println(temp.data);
        }

    }

    public node insertAtBegning(node head,Object data)
    {
      node newnode=new node(data);
      if(head==null)
          return newnode;

      newnode.next=head;
      head=newnode;
      size++;
      return head;
    }

    public node insetAtEnd(node head,Object data){
        node newnode=new node(data);
        if(head==null) head=newnode;
        node temp=head;
        for(temp=head;temp.next!=null;temp=temp.next){
        }
        temp.next=newnode;
        size++;
        return head;
    }

    public int  getSize(node head){
        return size;
    }

    public node insertAtMid(node head,Object data){
        node newnode=new node(data);
        if(head==null) return newnode;
        if(head.next==null) head=insertAtBegning(head,data);
        int mid=(1+getSize(head))/2;

        node temp=head;
        for(int i=2;i<mid;i++){
          temp=temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        size++;
return head;
    }

    public node inserAtAutomatic(node head,Object data){
        // precondition the list is in Acending order
        node newnode=new node(data);
        if(Integer.parseInt(newnode.data.toString())<Integer.parseInt(head.data.toString()))
            head=insertAtBegning(head,data);
        node temp=head;
        while (temp.next!=null){
            if(Integer.parseInt(newnode.data.toString())<Integer.parseInt(temp.next.data.toString())) break;
                temp=temp.next;
        }
               newnode.next=temp.next;
        temp.next=newnode;
        size++;
    return head;
    }

    public node insertAtAnyPosition(node head,int pos, Object data){
        node newnode=new node(data);
        if(head==null||pos==1) head=insertAtBegning(head,data);
        if(pos<1||pos>getSize(head)+1) throw new IllegalArgumentException();
        node temp=head;
        for(int i=2;i<pos;i++){
           temp=temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        size++;
        return head;
    }

    public node deleteFirst(node head){
        if(head==null) return null;
        head=head.next;
        size--;
        return head;

    }

    public node DeleteLast(node head){
        if(head==null) return null;
        if(head.next==null) return null;
        node temp=head;
        while (temp!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
        size--;
        return head;
    }

    public node deleteMid(node head){
        if(head==null) return null;
        if(head.next==null) return null;
        int mid=1+getSize(head)/2;
        node temp=head;
        for(int i=1;i<mid;i++){
            temp= temp.next;
        }
        temp=temp.next;
        size--;
        return head;
    }

    public node deleteAtAnyPos(node head,int pos){
        if(pos<1||pos>getSize(head)) throw new IllegalArgumentException();
        if(head==null) throw new RuntimeException("List is null");
        node temp=head;
        for(int i=1;i<pos;i++){
            temp=temp.next;
        }
        temp=temp.next;
        size--;
        return head;

    }

    public node deletethird(node head){
        if(head==null) return null;
        if(head.next.next==null) throw new IllegalArgumentException("There is no third element");
        node temp=head;
        for(int i=1;i<3;i++)
        {
            temp=temp.next;
        }
        temp=temp.next;
        size--;
        return head;
    }

    public node DeleteAll(node head){
        size=0;
       return head=null;


    }

    public node MergeTwoList(node head,node head2)
    {
      node temp=head;
      for(temp=head;temp.next!=null;temp=temp.next){

      }
        temp.next=head2;
      return head;
    }

    public node copy(node head)
    {
       if( head==null) return null;
       node head2=new node(head.data);
       node temp=head.next;
       for(temp=head.next;temp!=null;temp=temp.next)
       {
         head2.next=new node(head.next.data);
       }
        return head2;
    }

    public boolean search(node head,int target){
        if(head==null)  return false;
        node temp=head;
        for(temp=head;temp!=null;temp=temp.next)
        {
            if(Integer.parseInt(temp.data.toString())==target)
                return true;

        }
        return false;
    }

    public void update(node head,int target,int replacement)
    {
      for(node temp=head;temp!=null;temp= temp.next){
          if(Integer.parseInt(temp.data.toString())==target){
              temp.data=replacement;
          return;}
      }
    }

    public void reverse(node head)
    {
      if(head==null) return;
      Object[] array=new Object[getSize(head)];
      int count=0;
      for(node temp=head;temp!=null;temp=temp.next){
         array[count++]=temp.data;
      }
        node temp=head;
      for(int i=array.length-1;i>=0;i--){
          temp.data=array[i];
          temp=temp.next;
      }



    }

    public int heighest(node head) {
        int hig = Integer.parseInt(head.data.toString());
        for (node temp = head.next; temp != null; temp = temp.next) {
            if (hig < Integer.parseInt(temp.data.toString())) hig = Integer.parseInt(temp.data.toString());
            return hig;
        }
        return 0;
    }

    public int Minimum (node head){
            int min = Integer.parseInt(head.data.toString());
            for (node temp = head.next; temp != null; temp = temp.next) {
                if (min > Integer.parseInt(temp.data.toString())) min = Integer.parseInt(temp.data.toString());
                return min;
            }
           return 0;
        }


    public boolean isAscending(node head) {
        if (head == null || head.next == null) return true;
        for (node n = head; n.next.next != null; n = n.next)
            if (Integer.parseInt(n.data.toString()) > Integer.parseInt(n.next.data.toString())) return false;
        return true;
    }

    public boolean isDescending(node head){
            if(head==null||head.next==null)return true;
            for(node n=head;n.next.next!=null;n=n.next)if(Integer.parseInt(n.data.toString())<Integer.parseInt(n.next.data.toString()))return false;
            return true;
        }

}
