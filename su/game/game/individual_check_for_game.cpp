#include<iostream>
#include<cmath>
#include<cstdio>
#include<string>
#include<vector>
#include<algorithm>
#include<conio2.h>
using namespace std;

int number_counter[10]={0};



class initial_value
{
	public:
	int ini_value[9][9];
	int old_value_containner[9][9];
	void copy_old_value(void);
	void take_ini_value(void);
	void print_ini_value(void);
};

void initial_value::copy_old_value(void)
{
	for(int i=0;i<9;i++)
	for(int j=0;j<9;j++)
	old_value_containner[i][j]=ini_value[i][j];
}

void initial_value::take_ini_value(void)
{
//	  cout<<"int fn take"<<endl;
	for(int i=0;i<9;i++)
		for(int j=0;j<9;j++)
		{
//	  	  cout<<"came to cin"<<endl;
		cin>> ini_value[i][j];	  	  	  
		}

}
void initial_value::print_ini_value(void)
{
//	  cout<<"int fn print"<<endl;
	cout<<endl<<endl;
	int countl=0;
	for(int i=0;i<9;i++,countl++)
	{
		if(countl==3)
		{
			cout<<endl;
			countl=0;
		}
		int count=0;
		for(int j=0;j<9;j++,count++)
		{	
			if(count==3)
			{
				cout<<" ";
				count=0;
			}
			if(old_value_containner[i][j]==0)
			{
				if(ini_value[i][j]!=0)
				textcolor(GREEN);
				else textcolor(RED);				
			}
			else textcolor(WHITE);
			cout<<ini_value[i][j]<<" ";
			
			
		}
		cout<<endl;
	}
	textcolor(WHITE);
}
class individual_check : public initial_value
{
	private:
	bool testing_availability_of_number(int,int,int);
	public:
	void colum_check(void);
	void row_check(void);
};
void individual_check::colum_check(void)
{
			int hudaib;
	cout<<"checking individual colums."<<endl;
		cin>>hudaib;
	int found,blank_place_cnt,availability_cnt,unq_row;
	bool blank_place_finder[9],break_cnt,break_cnt_av,return_recive;
	for(int cl=0;cl<9;cl++)
	{
		found=0;
		for(int number=1;number<10;number++)
		{
			cout<<"checking "<<cl<<"th colum "<<"for number ::"<<number<<endl;
//	  	  	  cin>>hudaib;
			availability_cnt=0;
			break_cnt=false;
			for(int rw=0;rw<9;rw++)
			{
				if(ini_value[rw][cl]==number)
				{
					break_cnt=true;
					break;
				}
			}
			if(break_cnt==false)
			{
			//finding blank places.
				blank_place_cnt=0;
				break_cnt_av=false;
				for(int rwb=0;rwb<9;rwb++)
				{
					if(ini_value[rwb][cl]==0)
					{
						cout<<"blank found in::"<<rwb<<endl;
						blank_place_cnt++;
						return_recive=testing_availability_of_number(number,rwb,cl);
						if(return_recive==true)
						{
							unq_row=rwb;
							availability_cnt++;
						}
					}
					if(availability_cnt>1)
					{
						cout<<"doble availability found"<<endl;
						break_cnt_av=true;
						break;
					}
				}
				if(availability_cnt==1)
				{
					cout<<"uniqe availabbility found for: "<<number<<"In the place :"<<unq_row<<" "<<cl<<endl;
					ini_value[unq_row][cl]=number;
				}
			}
		}
	}
}



void individual_check::row_check(void)
{
	int hudaib;
	cout<<"checking individual rows."<<endl;
		cin>>hudaib;
	int found,blank_place_cnt,availability_cnt,unq_colum;
	bool blank_place_finder[9],break_cnt,break_cnt_av,return_recive;
	for(int rw=0;rw<9;rw++)
	{
		found=0;
		for(int number=1;number<10;number++)
		{
			cout<<"checking "<<rw<<"th row "<<"for number ::"<<number<<endl;
//	  	  	  cin>>hudaib;
			availability_cnt=0;
			break_cnt=false;
			for(int cl=0;cl<9;cl++)
			{
				if(ini_value[rw][cl]==number)
				{
					break_cnt=true;
					break;
				}
			}
			if(break_cnt==false)
			{
			//finding blank places.
				blank_place_cnt=0;
				break_cnt_av=false;
				for(int clb=0;clb<9;clb++)
				{
					if(ini_value[rw][clb]==0)
					{
						cout<<"blank found in::"<<clb<<endl;
						blank_place_cnt++;
						return_recive=testing_availability_of_number(number,rw,clb);
						if(return_recive==true)
						{
							unq_colum=clb;
							availability_cnt++;
						}
					}
					if(availability_cnt>1)
					{
						cout<<"doble availability found"<<endl;
						break_cnt_av=true;
						break;
					}
				}
				if(availability_cnt==1)
				{
					cout<<"uniqe availabbility found for: "<<number<<"In the place :"<<rw<<" "<<unq_colum<<endl;
					ini_value[rw][unq_colum]=number;
				}
			}
		}
	}
}



bool individual_check::testing_availability_of_number(int number,int row,int colum)
{
//testing his colum.
	cout<<"checking availability for :"<<number<<" "<<row<<" "<<colum<<endl;
	for(int i=0;i<9;i++)
	{
		if(i!=row)
		if(ini_value[i][colum]==number)
		{
			cout<<" not availave 1"<<endl;
			return false;
		}
	}
	//testing his row.
	for(int i=0;i<9;i++)
	{
		if(i!=colum)
		if(ini_value[row][i]==number)
		{
			cout<<" not availave 2"<<endl;
			return false;
		}
	}
	//testin his home.
	int row_cat,colum_cat;
	row_cat=row/3;
	colum_cat=colum/3;
	int lr,lc;
	lr=row_cat*3;
	for(int i=0;i<3;i++,lr++)
	{
		lc=colum_cat*3;
		for(int j=0;j<3;j++,lc++)
		{
			if(ini_value[lr][lc]==number)
			{
				cout<<"matched  ::"<<lr<<" "<<lc<<"with::"<<ini_value[lr][lc]<<endl;
				cout<<" not availave 3"<<endl;
				return false;
			}
		}
	}
	cout<<"availave"<<endl;
	return true;
}

int main()
{
	individual_check a;
	a.take_ini_value();
	a.copy_old_value();
	a.print_ini_value();
	a.colum_check();
	a.print_ini_value();
	a.row_check();
	a.print_ini_value();
	cout<<"all method done well"<<endl<<endl<<"last position is"<<endl;
	a.print_ini_value();
	return 0;
}

