package InterfacesAbstract;

public class SearchTree implements NodeList {

    private ListItem root;

    public SearchTree(ListItem root) {
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

        while (true) {

            int comparison = current.compareTo(newItem);

            if (comparison == 0) {
                return false; // duplicate not allowed
            }

            // go left
            else if (comparison > 0) {

                if (current.previous() != null) {
                    current = current.previous();
                } else {
                    current.setPrevious(newItem);
                    return true;
                }

            }

            // go right
            else {

                if (current.next() != null) {
                    current = current.next();
                } else {
                    current.setNext(newItem);
                    return true;
                }
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {

        if (root == null || item == null) {
            return false;
        }

        ListItem current = root;
        ListItem parent = null;

        while (current != null) {

            int comparison = current.compareTo(item);

            if (comparison == 0) {

                performRemoval(current, parent);
                return true;

            } else if (comparison > 0) {

                parent = current;
                current = current.previous();

            } else {

                parent = current;
                current = current.next();
            }
        }

        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {

        // case 1: node has 2 children
        if (item.previous() != null && item.next() != null) {

            ListItem successorParent = item;
            ListItem successor = item.next();

            while (successor.previous() != null) {
                successorParent = successor;
                successor = successor.previous();
            }

            item.setValue(successor.getValue());

            performRemoval(successor, successorParent);
            return;
        }

        // case 2: root node
        if (parent == null) {

            if (item.previous() != null) {
                root = item.previous();
            } else {
                root = item.next();
            }

            return;
        }

        // determine if item is left or right child
        if (parent.previous() == item) {

            parent.setPrevious(item.previous() != null ? item.previous() : item.next());

        } else {

            parent.setNext(item.previous() != null ? item.previous() : item.next());
        }
    }

    @Override
    public void traverse(ListItem root) {

        if (root != null) {

            if (root.previous() != null) {
                traverse(root.previous());
            }

            System.out.println(root.getValue());

            if (root.next() != null) {
                traverse(root.next());
            }

        } else {
            System.out.println("The tree is empty");
        }
    }
}