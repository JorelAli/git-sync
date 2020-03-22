# git-sync 
Quick, deployable, organised git repository cloning system

_git-sync_ is a git repository cloning system which can clone repositories in a certain file structure for easy repository management. Originally thought up by [AnachronisticTech](https://github.com/AnachronisticTech/git-sync), this repository is an inferior replica which only implements the cloning feature (whereas AnachronisticTech's original idea includes batch git repository syncing).

## Usage

To use _git-sync_, you will first need a `config.gitsync` file in the directory where files will be stored. An example of the `config.gitsync` file is below:

```
using domain "https://github.com/JorelAli/";

- git-sync

inside Minecraft {
    + 1.13-Command-API
    - Chairs
}

inside NixOS {
    - NixProjects
    + NixOS4Noobs
    - nixos
}

inside ElmProjects {
    + Elm-Markdown-Latex
    - ElmDesktop
    - Elm-Brainfuck-IDE
}
```

In this example, we state the domain in which all repositories will be under. In this case, we have repositories linked via `https://github.com/JorelAli/git-sync`, so the domain is `https://github.com/JorelAli/` (note the trailing `/`).

We then declare our repositories to include. If we want to clone the repository, it is denoted with `+`. Likewise, if we _don't_ want to clone the repository, it is denoted with `-`. This is useful if you want to clone a specific repository on a machine, but don't want to clone that repository on another machine, whilst still maintaining the entire structure.

Finally, we can declare _where_ to store each of these repositories. In the example above, we clone the `Elm-Markdown-Latex` repository inside a folder called `ElmProjects`. This can be nested as much as possible, for example:

```
...

inside ElmProjects {
    inside OtherFolder {
        + Elm-Markdown-Latex
    }
}
```

### Running the program

The program is run using the following command:

```
java -jar git-sync.jar
```

If we take the example above, running this will create the following directory structure:

```
.
├── Minecraft 
│   └── 1.13-Command-API 
│       ├── README.md 
│       ├── ... 
│       └── images 
│           ├── choice.gif
│           ├── explode.gif
│           ├── printnumber.gif
│           └── selfdestruct.gif
├── NixOS 
│   └── NixOS4Noobs          
│       └── ...
└── ElmProjects
    └── Elm-Markdown-Latex
        └── ...
```
