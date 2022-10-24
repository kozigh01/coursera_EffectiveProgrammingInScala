# Effective Programming in Scala

Course: [coursera](https://www.coursera.org/learn/effective-scala/home/week1)

## Resources
* My repo readme: [wsl_Setup](https://github.com/kozigh01/wsl_Setup/edit/main/README.md)
* [Scala](https://www.scala-lang.org/)j
  * [Install Scala](https://www.scala-lang.org/download/)
  * Install specific release: [releases](https://www.scala-lang.org/download/all.html)
* [Coursier](https://get-coursier.io/)

## Setup for WSL2
* Coursier: [cli-installation](https://get-coursier.io/docs/cli-installation)
  * If a JVM other than default is desired:
    ```bash
    $ cs setup -jvm 11
    ```
  * Install Coursier: [install instructions](https://get-coursier.io/docs/cli-installation#linux)
    ```bash
    $ curl -fL https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-linux.gz | gzip -d > cs
    $ chmod +x c
    ```
  * After installing Coursier, run setup command:
    ```bash
    # standard install
    $ ./cs setup

    # install specific version
    $ cs install scala:3.2.0 && cs install scalac:3.2.0.
    ```
* Clone repo for course from github
* In repo directory, open VS Code  `$ code .`
