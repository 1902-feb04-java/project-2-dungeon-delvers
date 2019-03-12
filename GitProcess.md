Changing branch to 'adam':
$git checkout adam

Getting commits from master onto branch 'adam', when you're on branch 'adam':
$git merge origin/master
$git push

Adding new files to branch 'adam':
$git add .
$git commit
$git push

Merging changes on branch 'adam' into branch 'master':
For this we go to Github and create a "pull request".  This lets us merge the branch in,
see changes, make comments, and keeps everyone on the same page.  It will include on
'master' all the commits from the branch, plus one "merge commit".

Undoing changes to 'master':
Also on github, we can revert changes from a prior merge.  This will
produce a revert commit (that undoes whatever) and another merge commit on master.
