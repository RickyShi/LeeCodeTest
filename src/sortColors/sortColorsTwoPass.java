package sortColors;

public class sortColorsTwoPass {
	public void sortColors(int[] A) {
		int rNum = 0, wNum = 0, bNum = 0;
		for (int i : A) {
			if (i == 0) {
				rNum++;
			}
			if (i == 1) {
				wNum++;
			}
			if (i == 2) {
				bNum++;
			}
		}
		int k = 0;
		for (; k < rNum; k++) {
			A[k] = 0;
		}
		for (; k < wNum + rNum; k++) {
			A[k] = 1;
		}
		for (; k < wNum + rNum + bNum; k++) {
			A[k] = 2;
		}
	}
}
