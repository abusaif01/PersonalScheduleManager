#include<iostream>
#include<cmath>
#include<cstdio>
#include<string>
#include<vector>
#include<algorithm>
#include<conio2.h>
using namespace std;

int number_counter=0;



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
	for(int i=8;i>=0;i--)
		for(int j=0;j<9;j++)
		{
		cin>> ini_value[i][j];
			if(ini_value[i][j]!=0)
			number_counter++;
		}
cout<<"given numbers::"<<number_counter<<endl;

}
void initial_value::print_ini_value(void)
{	 
	{
		textcolor(RED);
		for(int l=0;l<12;l++)	 
			cout<<"-";
	}
	cout<<endl<<endl;
	int countl=0;
	for(int i=8;i>=0;i--,countl++)
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
				textcolor(RED);
				else textcolor(WHITE);   	 	 	 	  	  	  
			}
			else textcolor(GREEN);
			cout<<ini_value[i][j]<<" ";
			
			
		}
		cout<<endl;
	}
	textcolor(WHITE);
}


class check_colum_for_unq : public initial_value
{
	private:
	void set_block(int,int);
	public:
	bool never_chk_colum_for[3][10];
	int found_in_colum[2],found_in_row[2];
	void check_column_for_two_value(void);

	void boolinitializerc(void);
	
};
void check_colum_for_unq::boolinitializerc(void)
{
//	  cout<<"initilizing bool value"<<endl;
	for(int i=0;i<3;i++)
	for(int j=0;j<10;j++)
	never_chk_colum_for[i][j]=0;
}

void check_colum_for_unq::check_column_for_two_value()
	{
//	  	  cout<<"In method check_colum_for_two_value"<<endl;
		for(int i=0;i<3;i++)
		{
			int match;
//	  	  	  cout<<endl<<endl<<"working with "<<i<<"th part"<<endl<<endl;
			for(int number=1;number<=9;number++)
			{
//	  	  	  	  cout<<"working with number :"<<number<<endl;
//	  	  	  	  int hudai;
//	  	  	  	  cin>>hudai;
				match=0;
				if(never_chk_colum_for[i][number]==false)
				for(int cl=(i*3);cl<((i+1)*3);cl++)
				{
					for(int rw=0;rw<9;rw++)
					{
//	  	  	  	  	  	  cout<<"checking :"<<rw<<cl<<endl;
						if(ini_value[rw][cl]==number)
						{
//	  	  	  	  	  	  	  cout<<"match found"<<endl<<"match ="<<match<<endl;
							found_in_colum[match]=cl;
							found_in_row[match]=rw;
							match++;
							break;
						}
					}
				}
				
				if(match==3)
				{
	//	  	  	  	  cout<<"3 match found for number :"<<number<<endl;
					never_chk_colum_for[i][number]=true;
				}
				else if(match==2)
				{
	//	  	  	  	  cout<<"2 match found for number :"<<number<<endl; 
					set_block(number,i);
				}
				
			}
		}
	//	  cout<<"this is the end of check_colum_for_two_value."<<endl;
	}
void check_colum_for_unq ::set_block(int number,int catg_of_working_colum)
{
	//finding three row for check.
//	  cout<<"working in set block with: "<<number;
//	  cout<<"calculatin for : row_catag_for_search"<<"found_in_row[0] found_in_row[1]="<<found_in_row[0]<<" "<<found_in_row[1]<<endl;
	
	int row_catag_for_search=3-(found_in_row[0]/3)-(found_in_row[1]/3);
	
//	  cout<<"row_catag_for_search::"<<row_catag_for_search<<endl;
	
	bool three_free_row[3]={1,1,1};

	//free colum.
	int free_colum=3-(found_in_colum[0]%3+found_in_colum[1]%3);
		free_colum=free_colum+(3*catg_of_working_colum);
//	  	  cout<<"catg_of_working_colum::"<<catg_of_working_colum<<endl;
//	  cout<<"free colum :"<<free_colum<<endl;
	int blank=3;
	int i=(row_catag_for_search*3);	   
	for(int j=0; j<3;  j++,i++)
	{
		if(ini_value[i][free_colum]!=0)
			{
	//	  	  	  cout<<"not blank faound  :"<<i<<"th row becomes false"<<endl;;
				blank--;
				three_free_row[i]=false;
			}
	}
	if(blank==1)
	{
		int temp;
			for(int l=0;l<3;l++)
			{
				if(three_free_row[l]==true)
				temp=l;
			}
			temp=temp+(row_catag_for_search*3);
			ini_value[temp][free_colum]=number;
			number_counter++;
	//	  cout<<"uniqe found for :"<<number<<" IN the place :"<<temp<<" "<<free_colum<<endl;
	}
	else 
	{
		row_catag_for_search=3-(found_in_row[0]/3)-(found_in_row[1]/3);
		int row_being_chked=(row_catag_for_search*3);
		free_colum=3-(found_in_colum[0]%3+found_in_colum[1]%3);
		free_colum=free_colum+(3*catg_of_working_colum);
		
	//	  cout<<"row_being_chked(started) ::"<<row_being_chked<<endl<<"free_colum ::"<<free_colum<<endl;
		for(int j=0; j<3;j++,row_being_chked++)
		{
	//	  	  cout<<"cheking rows for block"<<endl;
			if(three_free_row[j]==false)
			{
	//	  	  	  cout<<"false found"<<endl;
				continue;
			}	 	 
			for(int cl=0;cl<9;cl++)
			{
				if( ini_value[row_being_chked][cl]==number)
				{
	//	  	  	  	  cout<<"row_being_chked::"<<row_being_chked<<endl;
	//	  	  	  	  cout<<"bolck found with number match"<<"   "<<row_being_chked<<"th row becomes false"<<endl;
					three_free_row[j]=false;
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
				if(three_free_row[l]==true)
				temp=l;
			}
			temp=temp+(row_catag_for_search*3);
	//	  	  cout<<"unq found for :"<<number<<"In the palce :"<<temp<<" "<<free_colum<<endl;
			ini_value[temp][free_colum]=number;
			number_counter++;
//			print_ini_value();
		}
	}
}

class check_row_for_unq : public check_colum_for_unq
{
	private:
	void set_block(int,int);
	public:
	bool never_chk_row_for[3][10];
	int found_in_colum[2],found_in_row[2];
	void check_row_for_two_value(void);

	void boolinitializer(void);
	
};
void check_row_for_unq::boolinitializer(void)
{
//	  cout<<"initilizing bool value"<<endl;
	for(int i=0;i<3;i++)
	for(int j=0;j<10;j++)
	never_chk_row_for[i][j]=0;
}

void check_row_for_unq::check_row_for_two_value()
	{
		int match;
		//cout<<"In method check_row_for_two_value"<<endl;
		for(int i=0;i<3;i++)
		{
			//cout<<endl<<endl<<"working with "<<i<<"th part"<<endl<<endl;
			for(int number=1;number<=9;number++)
			{
		//	  	  cout<<"working with number :"<<number<<endl;
//	  	  	  	  int hudai;
//	  	  	  	  cin>>hudai;
				match=0;
				if(never_chk_row_for[i][number]==false)
				for(int rw=(i*3);rw<((i+1)*3);rw++)
				{
					for(int cl=0;cl<9;cl++)
					{
						//cout<<"checking :"<<rw<<cl<<endl;
						if(ini_value[rw][cl]==number)
						{
							//cout<<"match found"<<endl<<"match ="<<match<<endl;
							found_in_colum[match]=cl;
							found_in_row[match]=rw;
							match++;
							break;
						}
					}
				}
			//	  else cout<<"cheking cancled because of never_chk_row_for"<<endl;
				if(match==3)
				{
				//	  cout<<"3 match found for number :"<<number<<endl;
					never_chk_row_for[i][number]=true;
				}
				else if(match==2)
				{
				//	  cout<<"2 match found for number :"<<number<<endl; 
					set_block(number,i);
				}
				
			}
		}
	//	  cout<<"this is the end of check_row_for_two_value."<<endl;
	//	  cout<<"step complete"<<endl<<" suduko is now  "<<endl;
		//char permission;
	//	  cout<<"do you want to change"<<endl;
	//	cin>>permission;
	}
void check_row_for_unq ::set_block(int number,int catg_of_working_row)
{
	//finding three row for check.
//	  cout<<"working in set block with: "<<number;
//	  cout<<"calculatin for : colum_catag_for_search"<<"found_in_colum[0] found_in_colum[1]="<<found_in_colum[0]<<" "<<found_in_colum[1]<<endl;
	
	int colum_catag_for_search=3-(found_in_colum[0]/3)-(found_in_colum[1]/3);
	
//	  cout<<"colum_catag_for_search::"<<colum_catag_for_search<<endl;
	
	bool three_free_colum[3]={1,1,1};

	//free row.
	int free_row=3-(found_in_row[0]%3+found_in_row[1]%3);
		free_row=free_row+(3*catg_of_working_row);
//	  	  cout<<"catg_of_working_row::"<<catg_of_working_row<<endl;
//	  cout<<"free row :"<<free_row<<endl;
	int blank=3;
	int i=(colum_catag_for_search*3);	   
	for(int j=0; j<3;  j++,i++)
	{
		if(ini_value[free_row][i]!=0)
			{
	//	  	  	  cout<<"not blank faound  :"<<i<<"th colum becomes false"<<endl;
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
	//	  cout<<"uniqe found for :"<<number<<" IN the place :"<<free_row<<" "<<temp<<endl;
		ini_value[free_row][temp]=number;
		number_counter++;
	//	print_ini_value();
	}
	else 
	{
		colum_catag_for_search=3-(found_in_colum[0]/3)-(found_in_colum[1]/3);
		int colum_being_chked=(colum_catag_for_search*3);
		free_row=3-(found_in_row[0]%3+found_in_row[1]%3);
		free_row=free_row+(3*catg_of_working_row);
		
	//	  cout<<"colum_being_chked(started) ::"<<colum_being_chked<<endl<<"free_row ::"<<free_row<<endl;
		for(int j=0; j<3;j++,colum_being_chked++)
		{
	//	  	  cout<<"cheking colum for block"<<endl;
			if(three_free_colum[j]==false)
			{
			//	  cout<<"false found"<<endl;
				continue;
			}	 	 
			for(int rw=0;rw<9;rw++)
			{
				if( ini_value[rw][colum_being_chked]==number)
				{
		//	  	  	  cout<<"colum_being_chked::"<<colum_being_chked<<endl;
		//	  	  	  cout<<"bolck found with number match"<<"   "<<colum_being_chked<<"th row becomes false"<<endl;
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
		//	  cout<<"unq found for :"<<number<<"In the palce :"<<free_row<<" "<<temp<<endl;
			ini_value[free_row][temp]=number;
			number_counter++;
		}
	}
}

class individual_check : public check_row_for_unq
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
//	  cout<<"checking individual colums."<<endl;
//		cin>>hudaib;
	int found,blank_place_cnt,availability_cnt,unq_row;
	bool blank_place_finder[9],break_cnt,break_cnt_av,return_recive;
	for(int cl=0;cl<9;cl++)
	{
		found=0;
		for(int number=1;number<10;number++)
		{
	//	  	  cout<<"checking "<<cl<<"th colum "<<"for number ::"<<number<<endl;
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
					//	  cout<<"blank found in::"<<rwb<<endl;
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
						//cout<<"doble availability found"<<endl;
						break_cnt_av=true;
						break;
					}
				}
				if(availability_cnt==1)
				{
				//	  cout<<"uniqe availabbility found for: "<<number<<"In the place :"<<unq_row<<" "<<cl<<endl;
					ini_value[unq_row][cl]=number;
					number_counter++;
					//print_ini_value();
				}
			}
		}
	}
}



void individual_check::row_check(void)
{
	int hudaib;
	//cout<<"checking individual rows."<<endl;
		//cin>>hudaib;
	int found,blank_place_cnt,availability_cnt,unq_colum;
	bool blank_place_finder[9],break_cnt,break_cnt_av,return_recive;
	for(int rw=0;rw<9;rw++)
	{
		found=0;
		for(int number=1;number<10;number++)
		{
		//	  cout<<"checking "<<rw<<"th row "<<"for number ::"<<number<<endl;
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
					//	  cout<<"blank found in::"<<clb<<endl;
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
					//	  cout<<"doble availability found"<<endl;
						break_cnt_av=true;
						break;
					}
				}
				if(availability_cnt==1)
				{
				//	  cout<<"uniqe availabbility found for: "<<number<<"In the place :"<<rw<<" "<<unq_colum<<endl;
					ini_value[rw][unq_colum]=number;
					number_counter++;
				//	print_ini_value();
				}
			}
		}
	}
}



bool individual_check::testing_availability_of_number(int number,int row,int colum)
{
//testing his colum.
//	  cout<<"checking availability for :"<<number<<" "<<row<<" "<<colum<<endl;
	for(int i=0;i<9;i++)
	{
		if(i!=row)
		if(ini_value[i][colum]==number)
		{
		//	  cout<<" not availave 1"<<endl;
			return false;
		}
	}
	//testing his row.
	for(int i=0;i<9;i++)
	{
		if(i!=colum)
		if(ini_value[row][i]==number)
		{
		//	  cout<<" not availave 2"<<endl;
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
			//	  cout<<"matched  ::"<<lr<<" "<<lc<<"with::"<<ini_value[lr][lc]<<endl;
			//	  cout<<" not availave 3"<<endl;
				return false;
			}
		}
	}
//	  cout<<"availave"<<endl;
	return true;
}


class unit_check: public individual_check
{
	public:
	void check_each_unit(void);
};

void unit_check::check_each_unit(void)
{
	int row_catg,colum_ctg,row,colum,rw,cl,availability_cnt,unq_rw,unq_cl;
	bool break_cnt,recive_av;
	//unit running.
	for(row_catg=0;row_catg<3;row_catg++)
	{
		for(colum_catg=0;colum_catg<3;colum_catg++)
		{
			for(int number=1;number<10;number++)
			{
			//lunching nine small unit to check.
			break_cnt=false;
				for(int i=0,row=row_catg*3;i<3;i++,row++)
				{
					for(int j=0;colum=colum_catg*3;j<3;j++,colum++)
						if(number==ini_value[row][colum])
						{
							break_cnt=true;
							break;
						}
				}
				if(break_cnt==false)
				{
					availability_cnt=0;
					for(int k=0,rw=row_catg*3,k<3;k++,rw++)
					{
						for(int l=0;cl=colum_catg*3,l<3;cl++,l++)
						{
							if(ini_value[rw][cl]==0)
							{
								recive_av=testing_availability_of_number(number,rw,cl);
								if(recive_av==true)
								{
									unq_rw=rw;
									unq_cl=cl;
									availability_cnt++;
								}	
							}
						}
						if(availability_cnt>1)
						break;
					}
					if(availability_cnt==1)
					{
						cout<<"uniqe for::"<<number<<"  "<<unq_rw<<"  "<<unq_cl<<endl;
						int gada;
						cin>>gada;
						ini_value[unq_rw][unq_cl]=number;
						number_counter++;
					}
				}
				
				
			}
		}
		
	}
}






int main()
{
	char decission;
	int link;
		unit_check a;
		a.take_ini_value();
		a.copy_old_value();
		while(number_counter<81)
		{  	   
		a.boolinitializerc();
		a.check_column_for_two_value();
		a.boolinitializer();
		a.check_row_for_two_value();
		a.colum_check();
		a.row_check();
		a.check_each_unit();
		cout<<"calculating"<<endl;
		cout<<"number::"<<number_counter<<endl;
		a.print_ini_value();
		cin>>link;
		}
		
		
		
		
		cout<<"Calculation complete"<<endl<<"Do you want to see the result(y\n)"<<endl;
		cin>>decission;
		if(decission=='y')
		{
			clrscr();
			a.print_ini_value();
		}
		else cout<<"Ok !! Have another try."<<endl;
	return 0;
}




