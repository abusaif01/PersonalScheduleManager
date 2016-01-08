void individual_check::row_check(void)
{
	int found,blank_place_cnt,availability_cnt,unq_colum;
	bool blank_place_finder[9],break_cnt,break_cnt_av,return_recive;
	for(int rw=0;rw<9;rw++)
	{
		found=0;
		for(int number=1;number<10;number++)
		{
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
					cout<<"uniqe availabbility found for: "<<number<<"In the place :"<<row<<" "<<unq_cl<<endl;
					ini_value[row][unq_cl];
				}
			}
		}
	}
}