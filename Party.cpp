// You have N friends whom you want to take to your birthday party. You know the amount you will have to spend on each of your friend. You h ave R amount of money with you. You will take any K out of N friends to party such that the sum of total expenses on those K friends is exa ctly equal to R rupees. Else in any other condition you won't take any one to party. You have to find if it is possible to take them on party or not.
//For instance, suppose you have 5 friends on whom you will have to sp end 3,5,2,9,8 rupees respectively and you have 16 rupees, then yes it
//is possible to take them to party as 3+5+8 = 16. So, exact expenditur
//e is possible.
//Input
//Input Format
//First line contains 2 space separated integers that is N and R
//Second line contains N space integers which are the expenses of eac h friend
//Constraints
//N < 1000
//R < 1000
//Output
//Output Format
//Output "Party" if it is possible to take them to party.

#include <iostream>
#include <vector>

using namespace std;

bool isParty(int n, int expense, vector<int> nums, int id)
{
    if(expense == 0)
    {
        return true;
    }
    if(n == 0 || expense < 0)
    {
        return false;
    }
    bool check1 = isParty(n-1, expense - nums[id], nums, id + 1);
    bool check2 = isParty(n-1, expense, nums, id + 1);
    return check1 || check2;
}

int main()
{
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++)
    {
        cin >> nums[i];
    }
    int expense;
    cin >> expense;
    int id = 0;
    if(isParty(n, expense, nums, id))
    {
        cout << "True";
    }
    else
    {
        cout << "False";
    }
}
