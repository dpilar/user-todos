1. Clone the repository:
   [https://github.com/spring-projects/spring-shell](https://github.com/spring-projects/spring-shell)

2. Build the project and install it locally **without running tests**.

3. In the `spring-shell-sample-spring-boot` submodule, open `SpringShellApplication` and run the application from the command line.
   Refer to `README.md` for instructions on how to run it.

4. Get familiar with the shell commands and print a **hello** message.

5. Implement a new command `ls` with:

    * long option: `--dir`
    * short option: `-d`

6. The command should print the list of files and directories in the specified directory, for example:

   ```
   shell:>ls --dir c:/Windows
   ls c:/Windows

   addins
   adminer.version
   appcompat
   apppatch
   ```

7. Implement a completion provider named `lsCompletionProvider` for the `ls` command by creating a new bean that implements the `CompletionProvider` interface.

8. The completion provider should complete the given directory path with available subdirectories in the current directory. Example:

   ```
   shell:>ls --dir c:/Windows<TAB>
   c:/Windows/AppReadiness                             c:/Windows/Setup
   c:/Windows/Boot                                     c:/Windows/ShellComponents
   c:/Windows/Branding                                 c:/Windows/ShellExperiences
   c:/Windows/BrowserCore                              c:/Windows/SoftwareDistribution
   c:/Windows/CCM                                      c:/Windows/Speech
   c:/Windows/CSC                                      c:/Windows/Speech_OneCore
   ```
