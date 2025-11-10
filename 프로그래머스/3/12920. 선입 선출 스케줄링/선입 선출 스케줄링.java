// 1. 모든 CPU를 사용해서 작업을 다 완료 할 수 있는 최소 시간을 구한다. (이분탐색)
// 2. 총 작업시간에 CPU 시간 각각을 나눈 값을 모두 더해서 최소 시간 일 때 총 작업량을 구한다.
// 3. 총 작업량에서 처리해야 할 작업 수를 뺀다. ==> 초과한 작업 수가 나온다.
// 4. 코어를 뒤에서 부터 탐색하면서 (총 시간 % CPU 시간 == 0) 일 때 초과한 작업 수를 1뺀다.
// 5. 초과한 작업 수가 0이 되면 그 때가 마지막 작업을 처리하는 CPU 이다.

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;

        long time = getTime(0, 10000 * 50000, n, cores);
        long work = getWork(time, cores);

        work -= n;

        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (work == 0) {
                    answer = i + 1;
                    break;
                }
                work--;
            }
        }

        return answer;
    }

    long getTime(long min, long max, int n, int[] cores){
        long time = max;

        while(min <= max){
            long mid = (min + max) / 2;
            long work = getWork(mid, cores);

            if(work >= n){
                time = Math.min(time, mid);
                max = mid - 1;
            }
            else min = mid + 1;
        }

        return time;
    }

    long getWork(long time, int[] cores){
        long work = cores.length;

        for(int core: cores){
            work += time / core;
        }

        return work;
    }
}