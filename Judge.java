public class Judge {
	public Judge() {}

	public int findJudge (int N, int [][] trust) {
		int rval = 0;
		boolean found = false;
		int i = 1; 
		
		while (!found && i <= N) {
			int dependencies = 0;
			boolean dependent = false;
			for (int j = 0; j < trust.length; j++) {
				if (trust[j][0] == i) {
					dependent = true;
					break;
				} else if (trust[j][1] == i) {
					dependencies++;
				}		
			}
			
			if (dependencies == N - 1 && !dependent) {
				found = true;
				rval = i;
				break;
			}
			i++;
		}

		if (!found) {
			rval = -1;
		}
		return rval;
	}

	public static void main(String[] args) {
		Judge judge = new Judge();
		int N = 4;
		int[][] trust = {{1,3}, {1,4}, {2,3}, {2,4}, {4,3}};

		System.out.println(judge.findJudge(N, trust));
	}
}

	