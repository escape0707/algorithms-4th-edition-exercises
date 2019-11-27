#include <algorithm>
#include <chrono>
#include <fstream>
#include <iostream>
#include <iterator>
#include <vector>

using std::cin, std::cout, std::endl;
using std::ifstream;
using std::istream_iterator;
using std::sort;
using std::vector;
using std::chrono::duration_cast;
using std::chrono::steady_clock;
using std::chrono::nanoseconds;

int rank(int key, const vector<int> &a) {
  for (int low = 0, high = a.size(); low < high;) {
    int mid = low + (high - low) / 2;
    if (key < a[mid]) {
      high = mid;
    } else if (key > a[mid]) {
      low = mid + 1;
    } else {
      return mid;
    }
  }
  return -1;
}

int main(int argc, char *argv[]) {
  steady_clock::time_point begin = steady_clock::now();
  ifstream fin(argv[1]);
  vector<int> whitelist((istream_iterator<int>(fin)), istream_iterator<int>());

  sort(whitelist.begin(), whitelist.end());

  for (int key; cin >> key;) {
    if (rank(key, whitelist) < 0) {
      cout << key << endl;
    }
  }
  steady_clock::time_point end = steady_clock::now();
  cout << "Time difference = "
       << duration_cast<nanoseconds>(end - begin).count() << "[ns]" << endl;
  // Time difference = 10054206292[ns]
}
