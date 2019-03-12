I created a file on master using:
$code UserStories.md
$git add .
$git commit
$git push

Then my branch was behind master, so I had to update it:
$git checkout adam
$git merge origin/master
$git push

Then branch 'adam' was caught up with branch 'master' both on my computer and on github.