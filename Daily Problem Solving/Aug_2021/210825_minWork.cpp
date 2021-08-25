#include <iostream>
#include <vector>
#include <set>
using namespace std;



int getMin(int a, int b) {
	if (a <= b)
		return a;
	return b;
}

int solution(vector<vector<int>> field, int farmSize) {
	int minVal = -1;
	int start_x = 0, start_y = 0;
	bool mushy = false;

	for (int x = 0; x <= field.size() - farmSize; x++) {
		for (int y = 0; y <= field.size() - farmSize + 1; y++) {
			if (minVal == -1)
				minVal = 1000;
			int count = 0;
			for (int i = x; i < x + farmSize; i++) {
				for (int j = y; j < y + farmSize; j++) {
					if (field[i][j] == 1)
						count++;
					if (field[i][j] == 2) {
						mushy = true;
						break;
					}

				}

			}
			if (mushy)
				continue;
			minVal = getMin(minVal, count);
		}
	}

	if (minVal == 1000)
		minVal = -1;

	return minVal;
}

int main() {
	vector<vector<int>> v = { {0, 0, 1, 0, 0}, {1, 1, 0, 0, 2}, {1, 0, 0, 0, 0} };

	int ans = solution(v, 3);
	return 0;
}

