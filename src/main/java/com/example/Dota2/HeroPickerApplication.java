package com.example.Dota2;

import hero.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import service.FileService;
import service.exception.FileStorageException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
// don't forget to remove the 'exclude' part later.
public class HeroPickerApplication {

    private static final String FIELD_DELIMITER = "\\,";
    private static final String FILE_BASE_PATH = "C:\\Users\\samfo\\OneDrive\\Documents\\currentDota2Data.csv";

    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        // SpringApplication.run(HeroPickerApplication.class, args);
        HeroPickerApplication app = new HeroPickerApplication();
        app.initialize();
        app.run();


    }


    private void initialize() {
        // The purpose of this is to take in data about Heroes from a CSV and split them into appropriate fields.
        List<Hero> heroes = new ArrayList<>();

        try {
            List<Hero> lines = FileService.readContentsOfFile(FILE_BASE_PATH);
            for (Hero line : lines) {
                String[] fields = line.split(FIELD_DELIMITER);
                if (fields.length != 10) {
                    throw new RuntimeException("Error: Incorrect number of fields for hero: " + line + "in " + FILE_BASE_PATH);
                } else {
                    String name = fields[0];
                    String attributeType = fields[1];
                    String attackType = fields[2];
                    int position = Integer.parseInt(fields[3]);
                    int complexity = Integer.parseInt(fields[4]);
                    double belowArchonWinRate = Double.parseDouble(fields[5]);
                    double archonWinRate = Double.parseDouble(fields[6]);
                    double legendWinRate = Double.parseDouble(fields[7]);
                    double ancientWinRate = Double.parseDouble(fields[8]);
                    double aboveAncientWinRate = Double.parseDouble(fields[9]);

                    Hero hero = new Hero(name, attributeType, attackType, position, complexity, belowArchonWinRate,
                            archonWinRate, legendWinRate, ancientWinRate, aboveAncientWinRate);

                    heroes.add(hero);

                }
            } for (Hero hero:heroes){
                System.out.println("Name: " + hero.getName());
                System.out.println("Attribute Type: " + hero.getAttributeType());
                System.out.println("Attack Type: " + hero.getAttackType());
                System.out.println("Position: " + hero.getPosition());
                System.out.println("Complexity: " + hero.getComplexity());
                System.out.println("Below Archon Win Rate: " + hero.getBelowArchonWinRate());
                System.out.println("Archon Win Rate: " + hero.getArchonWinRate());
                System.out.println("Legend Win Rate: " + hero.getLegendWinRate());
                System.out.println("Ancient Win Rate: " + hero.getAncientWinRate());
                System.out.println("Above Ancient Win Rate: " + hero.getAboveAncientWinRate());
                System.out.println("------------------------");
            }
        } catch (FileStorageException e) {
            e.printStackTrace();
        }
    }


    // This whole menu needs changed, there are definitely ways to simplify it. I'll probably see if I can change
    // it to a switch case menu.
    private void run() {
        while (true) {
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please make a role selection from 1-5: ");
            if (mainMenuSelection == 1) {
                // Carry loop  = 1
                while (true) {
                    printSkillLevelMenu();
                    int skillLevelSelection = promptForMenuSelection("Please select a skill level from 1-5: ");
                    if (skillLevelSelection == 1) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Hero list with appropriate filters");
                            break;
                            // placeholder til I can figure out how to put the filtered list here.
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Carry heroes > Skill level: 1 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Carry heroes > Skill level: 1 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 2) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Carry heroes > Skill level: 2 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Carry heroes > Skill level: 2 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Carry heroes > Skill level: 2 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 3) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Carry heroes > Skill level: 3 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Carry heroes > Skill level: 3 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Carry heroes > Skill level: 3 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 4) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Carry heroes > Skill level: 4 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Carry heroes > Skill level: 4 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Carry heroes > Skill level: 4 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 5) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Carry heroes > Skill level: 5 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Carry heroes > Skill level: 5 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Carry heroes > Skill level: 5 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    }
                }
                break;


            } else if (mainMenuSelection == 2) {
                // Middle lane loop Midlane
                while (true) {
                    printSkillLevelMenu();
                    int skillLevelSelection = promptForMenuSelection("Please select a skill level from 1-5: ");
                    if (skillLevelSelection == 1) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 1 > Complexity: 1");
                            break;
                            // placeholder til I can figure out how to put the filtered list here.
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 1 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 1 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 2) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 2 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 2 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 2 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 3) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 3 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 3 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 3 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 4) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 4 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 4 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 4 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 5) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 5 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 5 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Midlane heroes > Skill level: 5 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    }
                }
                break;
            } else if (mainMenuSelection == 3) {
                // Offlane menu = 3
                while (true) {
                    printSkillLevelMenu();
                    int skillLevelSelection = promptForMenuSelection("Please select a skill level from 1-5: ");
                    if (skillLevelSelection == 1) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 1 > Complexity: 1");
                            break;
                            // placeholder til I can figure out how to put the filtered list here.
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 1 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 1 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 2) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 2 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 2 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 2 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 3) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 3 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 3 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 3 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 4) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 4 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 4 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 4 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 5) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 5 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 5 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Offlane heroes > Skill level: 5 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    }
                }
                break;
            } else if (mainMenuSelection == 4) {
                //  -- Soft Support = 4
                while (true) {
                    printSkillLevelMenu();
                    int skillLevelSelection = promptForMenuSelection("Please select a skill level from 1-5: ");
                    if (skillLevelSelection == 1) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 1 > Complexity: 1");
                            break;
                            // placeholder til I can figure out how to put the filtered list here.
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 1 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 1 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 2) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 2 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 2 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 2 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 3) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 3 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 3 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 3 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 4) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 4 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 4 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 4 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 5) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 5 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 5 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Soft Support heroes > Skill level: 5 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    }
                }
                break;
            } else if (mainMenuSelection == 5) {
                // Hard support menu = 5
                while (true) {
                    printSkillLevelMenu();
                    int skillLevelSelection = promptForMenuSelection("Please select a skill level from 1-5: ");
                    if (skillLevelSelection == 1) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 1 > Complexity: 1");
                            break;
                            // placeholder til I can figure out how to put the filtered list here.
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 1 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 1 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 2) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 2 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 2 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 2 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 3) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 3 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 3 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 3 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 4) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 4 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 4 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 4 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    } else if (skillLevelSelection == 5) {
                        printComplexityLevelMenu();
                        int complexityLevelSelection = promptForMenuSelection("Please select a complexity level from 1-3: ");
                        if (complexityLevelSelection == 1) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 5 > Complexity: 1");
                            // placeholder til I can figure out how to put the filtered list here.
                            break;
                        } else if (complexityLevelSelection == 2) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 5 > Complexity: 2");
                            break;
                        } else if (complexityLevelSelection == 3) {
                            System.out.println("Display list of: Hard Support heroes > Skill level: 5 > Complexity: 3");
                            break;
                        } else if (complexityLevelSelection == 0) {
                            break;
                        }
                    }
                }
                break;
            } else if (mainMenuSelection == 0) {
                break;
            }
        }
    }

//    public List<String> recommendHeroes(int position, int skillLevel, int complexity) {
//        // TODO: Implement recommendation algorithm based on user input
//        List<String> recommendedHeroes = new ArrayList<>();


    private void printMainMenu() {
        System.out.println("****** Welcome to the Dota 2 Hero picker app! ******");
        System.out.println("Please select the role you would like to play: (1-5)");
        System.out.println("1 = Hard Carry");
        System.out.println("2 = Midlane");
        System.out.println("3 = Offlane");
        System.out.println("4 = Soft Support");
        System.out.println("5 = Hard Support");

    }

    private void printSkillLevelMenu() {
        System.out.println("Select your skill level: (1-5): ");
        System.out.println("1 = Crusader or lower: (< 2000 MMR)");
        System.out.println("2 = Archon: (~2000-3000 MMR)");
        System.out.println("3 = Legend:  (~3000-4000 MMR)");
        System.out.println("4 = Ancient: (~4000-5000 MMR)");
        System.out.println("5 = Divine/Immortal: (5000+ MMR)");
    }

    private void printComplexityLevelMenu() {
        System.out.println("How complex of a hero would you like to play?");
        System.out.println("1 = Very simple to play");
        System.out.println("2 = Moderately difficult to play");
        System.out.println("3 = Very difficult to play");
        // Definitely need to phrase this better or add some more clarification. Just a placeholder for now to test
        // functionality.
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(userInput.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }
}