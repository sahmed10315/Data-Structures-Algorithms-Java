package priorityq.implementation.array;

/* 
 * Implementation of a priority queue by using an array
 * Time complexity: Insertion runs in O(N) time, deletion takes O(1) time
 * 
 * */
class Task {
	String job;
	int priority;

	public Task(String job, int priority) {
		this.job = job;
		this.priority = priority;
	}

	public String toString() {
		return "Job Name : " + job + ", Priority : " + priority;
	}
}

class PriorityQ {
	private int maxSize;
	private Task[] queArray;
	private int nItems;

	public PriorityQ(int s) {
		maxSize = s;
		queArray = new Task[maxSize];
		nItems = 0;
	}

	public void insert(String job, int priority) {
		int j;
		if (isFull())
			throw new RuntimeException("It is full");
		Task newTask = new Task(job, priority);
		if (nItems == 0)
			queArray[nItems++] = newTask;
		else {
			for (j = nItems - 1; j >= 0; j--) {
				if (newTask.priority > queArray[j].priority)
					queArray[j + 1] = queArray[j];
				else
					break;
			}
			queArray[j + 1] = newTask;
			nItems++;
		}
	}

	public Task remove() {
		if (isEmpty())
			throw new RuntimeException("It is empty");
		return queArray[--nItems];
	}

	public Task peekMin() {
		if (isEmpty())
			throw new RuntimeException("It is empty");
		return queArray[nItems - 1];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}
}

public class PriorityQueue {
	public static void main(String[] args) {
		PriorityQ thePQ = new PriorityQ(5);
		thePQ.insert("Job 1", 30);
		thePQ.insert("Job 2", 50);
		thePQ.insert("Job 3", 10);
		thePQ.insert("Job 4", 40);
		thePQ.insert("Job 5", 20);

		while (!thePQ.isEmpty()) {
			Task item = thePQ.remove();
			System.out.println(item);
		} 
		System.out.println("");
	}
}