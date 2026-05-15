package InterfacesAbstract;

public class MyLinkedList implements NodeList {

    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem newItem) {

        if (root == null) {
            root = newItem;
            return true;
        }

        ListItem current = root;

        while (current != null) {
            int comparison = current.compareTo(newItem);

            if (comparison == 0) {
                return false; // duplicate
            } else if (comparison < 0) {
                // move right
                if (current.next() != null) {
                    current = current.next();
                } else {
                    current.setNext(newItem);
                    newItem.setPrevious(current);
                    return true;
                }
            } else {
                // insert before current
                if (current.previous() == null) {
                    newItem.setNext(current);
                    current.setPrevious(newItem);
                    root = newItem;
                } else {
                    ListItem prev = current.previous();

                    prev.setNext(newItem);
                    newItem.setPrevious(prev);

                    newItem.setNext(current);
                    current.setPrevious(newItem);
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {

        if (item == null || root == null) return false;

        ListItem current = root;

        while (current != null) {
            int comparison = current.compareTo(item);

            if (comparison == 0) {
                // found node
                if (current == root) {
                    root = current.next();
                    if (root != null) {
                        root.setPrevious(null);
                    }
                } else {
                    ListItem prev = current.previous();
                    ListItem next = current.next();

                    prev.setNext(next);
                    if (next != null) {
                        next.setPrevious(prev);
                    }
                }
                return true;
            } else if (comparison < 0) {
                current = current.next();
            } else {
                return false; // not found in sorted list
            }
        }

        return false;
    }

    @Override
    public void traverse(ListItem root) {

        if (root == null) {
            System.out.println("The list is empty");
            return;
        }

        ListItem current = root;

        while (current != null) {
            System.out.println(current.getValue());
            current = current.next();
        }
    }
}
