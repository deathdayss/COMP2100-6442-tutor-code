## Set up and use the code in your local machine:

1. Fork the repository

2. Clone the repository from your forked repository

3. Go to the cloned directory

4. Open the terminal in the directory

5. Execute the below command to add the upstream
```bash
git remote add upstream https://github.com/deathdayss/COMP2100-6442-tutor-code   
```

7. Execute the below commands sync your master branch with the master branch of the upstream before each class
```bash
git fetch upstream
git checkout master
git merge upstream/master
git push
```
