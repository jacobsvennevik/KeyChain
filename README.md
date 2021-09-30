<!-- PROJECT LOGO -->
<br />
<p align="center">
  <img src="images/keychainIcon.png" alt="Logo" width="80" height="80">
  <h3 align="center">KeyChain</h3>
     <br />
    <br />
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
        <li> <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#Dependencies">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
      </li>
    <li><a href="#usage">Usage</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

A program that will generate, cipher, save, store, find and then decipher your passwords. 

<!-- GETTING STARTED -->
## Getting Started

### Dependencies

<!-- Dependencies -->
* Made for macOS Catalina version 10, not tested on other operating systems. 


<!-- Installation -->
### Installation

To run the program, install with git clone

   ```sh
   git clone https://github.com/jacobsvennevik/KeyChain.git
   ```

<!-- USAGE EXAMPLES -->
## Usage


After installation open the file in an editor, go to MainMenu.java in the home.GUI package and run the file. The Main menu will open and you can choose what you want to do.


![Usage Main Menu][MainMenu]

The generate password button will open another menu. Here you write how long you want the password to be and to which website the password is created for.


![Usage Generate Password][Generate]

The create password button will let you choose your own password and then save it to the website the password is for.

![Usage get Password][Get]

The get button will get the password to a website.

![Usageerrors][Error1]

The different menu's will not create or generate a password if there already exist a password to the chosen website.

![Usage errors][Error2]

Create password does not work if the password is not equal to each other.

![Usage errors][Error3]

Find Password does not work if the website 





<!-- IMAGES -->
[MainMenu]: images/mainMenu.png
[Generate]: images/generate.png
[Get]: images/getPas.png

