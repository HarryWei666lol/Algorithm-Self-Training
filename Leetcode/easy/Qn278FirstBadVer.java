package easy;

public class Qn278FirstBadVer {
	// time 99.81%, space 100%
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
          int mid = left + (right - left) / 2;

          if (isBadVersion(mid)) {
            right = mid;
          } else {
            left = mid + 1;
          }
        }
        return left;
    }

	private boolean isBadVersion(int mid) {
		// Provided in API...
		return false;
	}

}
