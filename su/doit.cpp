#include<iostream>
#include<cmath>
#include<cstdio>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;


class primary
{
	public:
	vector<int> ini_value(9)(9);
	void input(void);
	void output(void);
};

void primary::take(void)
{
	for(int i=0;i<9;i++)
	for(int j=0;j<9;j++)
	cin>>ini_value(i)(j);
}
void primary::output(void)
{
	for(int i=0;i<9;i++)
	for(int j=0;j<9;j++)
	cout<<ini_value(i)(j);
}


int main()
{
	primary input;
	return 0;
	
}

