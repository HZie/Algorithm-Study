// quest
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> quest) {
    int count = 0;
    int currExp = 0;
    
    for(int i = 0; i < quest.size(); ){
        if(quest[i][0] <= -1){
            i++;
            continue;
        }
        if(currExp >= quest[i][0]){
            currExp += quest[i][1];
            quest[i][0] = -1;
            count++;
            i = 0;
        }
        else{
            i++;
        }
        
    }
    
    return count;
}