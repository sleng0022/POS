# Read Me
First, I want to make sure that we are on the same boat for using github. We should create branch of what we are going 
to work for and do pull request if we satisfy our works. The master should not be touch; this branch should be our final code. 
If we find any bugs, we need to create a branch and fix the bugs and do a pull request.

Here is some steps for using git:

1. Create branch <br />
`git checkout -b branch_name`
2. Set up branch into repo <br />
`git push --set-upstream origin branch_name`
3. Now, you are set to make any changes on this branch. Once you make changes to the file. You can add and commit the file. <br />
  * Check what file did you just change `git status`
  * Add those files `git add file_name`
  * Enter commit message `git commit ` 
3. Pull the latest work first before push to branch <br />
`git pull`
4. Push all the works to the branch <br />
`git push`

In case after you pull the latest work, you might have to switch to other branch and pull again

Switch branch <br />
`git checkout branch_name` <br />
Pull <br />
`git pull`



