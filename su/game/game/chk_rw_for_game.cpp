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


class check_row_for_unq : public initial_value
{
	private:
	void set_block(int,int);
	public:
	bool never_chk_row_for[10];
	int found_in_colum[2],found_in_row[2];
	void check_row_for_two_value(void);

	void boolinitializer(void);
	
};
void check_row_for_unq::boolinitializer(void)
{
	cout<<"initilizing bool value"<<endl;
	for(int i=0;i<10;i++)
	never_chk_row_for[i]=0;
}

void check_row_for_unq::check_row_for_two_value()
	{
		cout<<"In method check_row_for_two_value"<<endl;
		for(int i=0;i<3;i++)
		{
			cout<<endl<<endl<<"working with "<<i<<"th part"<<endl<<endl;
			for(int number=1;number<=9;number++)
			{
				cout<<"working with number :"<<number<<endl;
				int hudai;
				cin>>hudai;
				int match=0;
				if(never_chk_row_for[number]==false)
				for(int rw=(i*3);rw<((i+1)*3);rw++)
				{
					for(int cl=0;cl<9;cl++)
					{
						cout<<"checking :"<<rw<<rw<<endl;
						if(ini_value[rw][cl]==number)
						{
							cout<<"match found"<<endl<<"match ="<<match<<endl;
							found_in_colum[match]=cl;
							found_in_row[match]=rw;
							match++;
							number_counter[number]++;
							break;
						}
					}
				}
				
				if(match==3)
				{
					cout<<"3 match found for number :"<<number<<endl;
					never_chk_row_for[number]=true;
				}
				else if(match==2)
				{
					cout<<"2 match found for number :"<<number<<endl; 
					set_block(number,i);
				}
				
			}
		}
		cout<<"this is the end of check_row_for_two_value."<<endl;
	}
void check_row_for_unq ::set_block(int number,int catg_of_working_row)
{
	//finding three row for check.
	cout<<"working in set block with: "<<number;
	cout<<"calculatin for : colum_catag_for_search"<<"found_in_colum[0] found_in_colum[1]="<<found_in_colum[0]<<" "<<found_in_colum[1]<<endl;
	
	int colum_catag_for_search=3-(found_in_colum[0]/3)-(found_in_colum[1]/3);
	
	cout<<"colum_catag_for_search::"<<colum_catag_for_search<<endl;
	
	bool three_free_colum[3]={1,1,1};

	//free row.
	int free_row=3-(found_in_row[0]%3+found_in_row[1]%3);
		free_row=free_row+(3*catg_of_working_row);
		cout<<"catg_of_working_row::"<<catg_of_working_row<<endl;
	cout<<"free row :"<<free_row<<endl;
	int blank=3;
	int i=(colum_catag_for_search*3);	   
	for(int j=0; j<3;  j++,i++)
	{
		if(ini_value[free_row][i]!=0)
			{
				cout<<"not blank faound  :"<<i<<"th colum becomes false"<<endl;
				blank--;
				three_free_colum[j]=false;
			}
	}
	if(blank==1)
	{
		int temp;
			for(int l=0;l<3;l++)
			{
				if(three_free_colum[l]==true)
				temp=l;
			}
			temp=temp+(colum_catag_for_search*3);
		cout<<"uniqe found for :"<<number<<" IN the place :"<<free_row<<" "<<temp<<endl;
		ini_value[free_row][temp]=number;
		print_ini_value();
	}
	else 
	{
		colum_catag_for_search=3-(found_in_colum[0]/3)-(found_in_colum[1]/3);
		int colum_being_chked=(colum_catag_for_search*3);
		free_row=3-(found_in_row[0]%3+found_in_row[1]%3);
		free_row=free_row+(3*catg_of_working_row);
		
		cout<<"colum_being_chked(started) ::"<<colum_being_chked<<endl<<"free_row ::"<<free_row<<endl;
		for(int j=0; j<3;j++,colum_being_chked++)
		{
			cout<<"cheking colum for block"<<endl;
			if(three_free_colum[j]==false)
			{
				cout<<"false found"<<endl;
				continue;
			}	 	 
			for(int rw=0;rw<9;rw++)
			{
				if( ini_value[rw][colum_being_chked]==number)
				{
					cout<<"colum_being_chked::"<<colum_being_chked<<endl;
					cout<<"bolck found with number match"<<"   "<<colum_being_chked<<"th row becomes false"<<endl;
					three_free_colum[j]=false;
					blank--;
				}
			}
		}
		//find which are not bolcked.

		if(blank==1)
		{
			int temp;
			for(int l=0;l<3;l++)
			{
				if(three_free_colum[l]==true)
				temp=l;
			}
			temp=temp+(colum_catag_for_search*3);
			cout<<"unq found for :"<<number<<"In the palce :"<<free_row<<" "<<temp<<endl;
			ini_value[free_row][temp]=number;
			print_ini_value();
		}
	}
}








int main()
{
	check_row_for_unq a;
	a.take_ini_value();
	a.copy_old_value();
	a.print_ini_value();
	a.boolinitializer();
	a.check_row_for_two_value();
	
	cout<<"all method done well"<<endl<<endl<<"last position is"<<endl;
	a.print_ini_value();
	return 0;
}




