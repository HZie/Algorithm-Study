// hit first
#include <string>
#include <vector>
#include <cmath>

using namespace std;

constexpr double BallDiameter = 2;

// 점과 점 사이의 거리
double getDistance(vector<double> p1, vector<double> p2){
    int pow_num = 0;
    for(int i = 0; i < p1.size(); i++){
        pow_num += pow(p1[i]-p2[i],2);
    }
    return sqrt(pow_num);
}

// 선과 점 사이의 직각 교차점
vector<double> intersection(vector<double> line, vector<double> point){
    
    vector<double> crossLine(2);
    crossLine[0] = line[1];
    crossLine[1] = -line[0];

    double d = crossLine[0] * point[0] - crossLine[1] * point[1];
    
    double y = d / (crossLine[0] * (line[1] / line[0]) - crossLine[1]);
    double x = line[1] / line[0] * y;
    
    vector<double> answer(2);
    answer[0] = x;
    answer[1] = y;
    return answer;
}


int solution(vector<vector<double>> objectBallPosList, vector<double> hitVector) {
    
    int answer = -1;
    int p_x=0;
    for(int i = 0; i < objectBallPosList.size(); i++){
        vector<double> ball = objectBallPosList[i];
        
        // 같은 사분면
        if(hitVector[0] * ball[0] < 0 || hitVector[1] * ball[1] < 0)
            continue;
        
        vector<double> iPoint = intersection(hitVector, ball);
        
        // 교차지점이 정답보다 큰 경우
        if(answer != -1 && abs(iPoint[0])-abs(p_x) > 0)
            continue;
        
        double dist = getDistance(ball, iPoint);
        if(dist < BallDiameter){
            answer = i;
            p_x = iPoint[0];
        }
    }
    
    return answer;
 
    
}