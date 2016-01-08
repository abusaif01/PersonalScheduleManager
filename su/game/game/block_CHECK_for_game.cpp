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