

public class OrderedList {
    private Queue<NumCount> lst;

    public OrderedList() {
        lst = new Queue<>();
    }

    public void insertNum(int x) {
        if (lst.isEmpty()) {
            lst.insert(new NumCount(x, 1));
            return;
        }

        Queue<NumCount> tempQueue = new Queue<>();
        NumCount currentNumCount = lst.remove();
        while (currentNumCount != null) {
            if (currentNumCount.getNum() == x) {
                currentNumCount.setCount(currentNumCount.getCount() + 1);
                break;
            } else if (currentNumCount.getNum() > x) {
                tempQueue.insert(new NumCount(x, 1));
                tempQueue.insert(currentNumCount);
                break;
            } else {
                tempQueue.insert(currentNumCount);
                currentNumCount = lst.remove();
            }
        }

        if (currentNumCount == null) {
            tempQueue.insert(new NumCount(x, 1));
        }

        while (!lst.isEmpty()) {
            tempQueue.insert(lst.remove());
        }

        lst = tempQueue;
    }

    public int valueN(int n) {
        int sum = 0;
        Queue<NumCount> tempQueue = new Queue<>();
        NumCount result = null;

        while (!lst.isEmpty()) {
            NumCount currentNumCount = lst.remove();
            sum += currentNumCount.getCount();
            if (sum >= n) {
                result = currentNumCount;
                break;
            }
            tempQueue.insert(currentNumCount);
        }

        while (!tempQueue.isEmpty()) {
            lst.insert(tempQueue.remove());
        }

        if (result != null) {
            return result.getNum();
        } else {
            return -1;
        }
    }

    public void removeNum(int x) {
        Queue<NumCount> tempQueue = new Queue<>();
        boolean found = false;

        while (!lst.isEmpty()) {
            NumCount currentNumCount = lst.remove();
            if (currentNumCount.getNum() == x) {
                if (currentNumCount.getCount() > 1) {
                    currentNumCount.setCount(currentNumCount.getCount() - 1);
                    tempQueue.insert(currentNumCount);
                }
                found = true;
                break;
            } else {
                tempQueue.insert(currentNumCount);
            }
        }

        while (!lst.isEmpty()) {
            tempQueue.insert(lst.remove());
        }

        if (found) {
            while (!tempQueue.isEmpty()) {
                lst.insert(tempQueue.remove());
            }
        } else {
            
            while (!tempQueue.isEmpty()) {
                lst.insert(tempQueue.remove());
            }
        }
    }
}
