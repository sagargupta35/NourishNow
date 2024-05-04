package com.sagar.nourishnow.common

import dagger.internal.MapBuilder


object Constants{
    val majorNutrientsMap: Map<String, List<String>> = mapOf(
        "Carbohydrates" to listOf("CHOCDF.net", "CHOCDF"),
        "Fats" to listOf("FAT", "FASAT", "FATRN", "FAMS", "FAPU"),
        "Fibre" to listOf("FIBTG"),
        "MicroNutrients" to listOf("FE", "NA", "K", "THIA", "NIA", "MG", "P", "RIBF", "ZN"),
        "Vitamins" to listOf("VITA_RAE", "VITB12", "VITB6", "VITC", "VITD", "TOCPHA", "VITK1"),
        "Water" to listOf("WATER"),
        "Sugar" to listOf("SUGAR.added", "SUGAR.alcohol", "SUGAR")
    )

    val emptyValue = "Unknown"
    val jsonData = """
    {
      "uri": "http://www.edamam.com/ontologies/edamam.owl#recipe_4178837fb5f242e8a006ce73b98e02eb",
      "yield": 6,
      "calories": 1090,
      "totalCO2Emissions": 5145.482454999999,
      "co2EmissionsClass": "E",
      "totalWeight": 741.375,
      "dietLabels": [],
      "healthLabels": [
        "SUGAR_CONSCIOUS",
        "LOW_POTASSIUM",
        "KIDNEY_FRIENDLY",
        "GLUTEN_FREE",
        "WHEAT_FREE",
        "EGG_FREE",
        "PEANUT_FREE",
        "TREE_NUT_FREE",
        "SOY_FREE",
        "FISH_FREE",
        "SHELLFISH_FREE",
        "PORK_FREE",
        "RED_MEAT_FREE",
        "CRUSTACEAN_FREE",
        "MUSTARD_FREE",
        "SESAME_FREE",
        "LUPINE_FREE",
        "MOLLUSK_FREE",
        "ALCOHOL_FREE",
        "NO_SUGAR_ADDED",
        "SULPHITE_FREE"
      ],
      "cautions": [
        "SULFITES"
      ],
      "totalNutrients": {
        "ENERC_KCAL": {
          "label": "Energy",
          "quantity": 1090.6877500000003,
          "unit": "kcal"
        },
        "FAT": {
          "label": "Total lipid (fat)",
          "quantity": 29.383159999999993,
          "unit": "g"
        },
        "FASAT": {
          "label": "Fatty acids, total saturated",
          "quantity": 16.045542500000003,
          "unit": "g"
        },
        "FATRN": {
          "label": "Fatty acids, total trans",
          "quantity": 0,
          "unit": "g"
        },
        "FAMS": {
          "label": "Fatty acids, total monounsaturated",
          "quantity": 9.46524775,
          "unit": "g"
        },
        "FAPU": {
          "label": "Fatty acids, total polyunsaturated",
          "quantity": 2.116783,
          "unit": "g"
        },
        "CHOCDF": {
          "label": "Carbohydrate, by difference",
          "quantity": 177.34986499999997,
          "unit": "g"
        },
        "CHOCDF.net": {
          "label": "Carbohydrates (net)",
          "quantity": 175.22843999999998,
          "unit": "g"
        },
        "FIBTG": {
          "label": "Fiber, total dietary",
          "quantity": 2.1214250000000003,
          "unit": "g"
        },
        "SUGAR": {
          "label": "Sugars, total including NLEA",
          "quantity": 10.137730000000001,
          "unit": "g"
        },
        "PROCNT": {
          "label": "Protein",
          "quantity": 24.688175,
          "unit": "g"
        },
        "CHOLE": {
          "label": "Cholesterol",
          "quantity": 73.66,
          "unit": "mg"
        },
        "NA": {
          "label": "Sodium, Na",
          "quantity": 1230.6640000000002,
          "unit": "mg"
        },
        "CA": {
          "label": "Calcium, Ca",
          "quantity": 69.90275,
          "unit": "mg"
        },
        "MG": {
          "label": "Magnesium, Mg",
          "quantity": 97.31025,
          "unit": "mg"
        },
        "K": {
          "label": "Potassium, K",
          "quantity": 846.9285000000001,
          "unit": "mg"
        },
        "FE": {
          "label": "Iron, Fe",
          "quantity": 2.7490275,
          "unit": "mg"
        },
        "ZN": {
          "label": "Zinc, Zn",
          "quantity": 3.0597125,
          "unit": "mg"
        },
        "P": {
          "label": "Phosphorus, P",
          "quantity": 360.29650000000004,
          "unit": "mg"
        },
        "VITA_RAE": {
          "label": "Vitamin A, RAE",
          "quantity": 458.88174999999995,
          "unit": "µg"
        },
        "VITC": {
          "label": "Vitamin C, total ascorbic acid",
          "quantity": 6.382250000000001,
          "unit": "mg"
        },
        "THIA": {
          "label": "Thiamin",
          "quantity": 0.3295355,
          "unit": "mg"
        },
        "RIBF": {
          "label": "Riboflavin",
          "quantity": 0.5044435,
          "unit": "mg"
        },
        "NIA": {
          "label": "Niacin",
          "quantity": 10.203208,
          "unit": "mg"
        },
        "VITB6A": {
          "label": "Vitamin B-6",
          "quantity": 0.65068675,
          "unit": "mg"
        },
        "FOLDFE": {
          "label": "Folate, DFE",
          "quantity": 62.01025,
          "unit": "µg"
        },
        "FOLFD": {
          "label": "Folate, food",
          "quantity": 62.01025,
          "unit": "µg"
        },
        "FOLAC": {
          "label": "Folic acid",
          "quantity": 0,
          "unit": "µg"
        },
        "VITB12": {
          "label": "Vitamin B-12",
          "quantity": 0.048279999999999997,
          "unit": "µg"
        },
        "VITD": {
          "label": "Vitamin D (D2 + D3)",
          "quantity": 0,
          "unit": "µg"
        },
        "TOCPHA": {
          "label": "Vitamin E (alpha-tocopherol)",
          "quantity": 1.069895,
          "unit": "mg"
        },
        "VITK1": {
          "label": "Vitamin K (phylloquinone)",
          "quantity": 15.60125,
          "unit": "µg"
        },
        "WATER": {
          "label": "Water",
          "quantity": 503.7494249999999,
          "unit": "g"
        }
      },
      "totalDaily": {
        "ENERC_KCAL": {
          "label": "Energy",
          "quantity": 54.53438750000001,
          "unit": "%"
        },
        "FAT": {
          "label": "Fat",
          "quantity": 45.20486153846153,
          "unit": "%"
        },
        "FASAT": {
          "label": "Saturated",
          "quantity": 80.22771250000002,
          "unit": "%"
        },
        "CHOCDF": {
          "label": "Carbs",
          "quantity": 59.11662166666665,
          "unit": "%"
        },
        "FIBTG": {
          "label": "Fiber",
          "quantity": 8.485700000000001,
          "unit": "%"
        },
        "PROCNT": {
          "label": "Protein",
          "quantity": 49.37635,
          "unit": "%"
        },
        "CHOLE": {
          "label": "Cholesterol",
          "quantity": 24.553333333333335,
          "unit": "%"
        },
        "NA": {
          "label": "Sodium",
          "quantity": 51.277666666666676,
          "unit": "%"
        },
        "CA": {
          "label": "Calcium",
          "quantity": 6.990275,
          "unit": "%"
        },
        "MG": {
          "label": "Magnesium",
          "quantity": 23.169107142857143,
          "unit": "%"
        },
        "K": {
          "label": "Potassium",
          "quantity": 18.01975531914894,
          "unit": "%"
        },
        "FE": {
          "label": "Iron",
          "quantity": 15.272374999999998,
          "unit": "%"
        },
        "ZN": {
          "label": "Zinc",
          "quantity": 27.815568181818183,
          "unit": "%"
        },
        "P": {
          "label": "Phosphorus",
          "quantity": 51.47092857142857,
          "unit": "%"
        },
        "VITA_RAE": {
          "label": "Vitamin A",
          "quantity": 50.986861111111104,
          "unit": "%"
        },
        "VITC": {
          "label": "Vitamin C",
          "quantity": 7.091388888888891,
          "unit": "%"
        },
        "THIA": {
          "label": "Thiamin (B1)",
          "quantity": 27.461291666666668,
          "unit": "%"
        },
        "RIBF": {
          "label": "Riboflavin (B2)",
          "quantity": 38.80334615384616,
          "unit": "%"
        },
        "NIA": {
          "label": "Niacin (B3)",
          "quantity": 63.77005,
          "unit": "%"
        },
        "VITB6A": {
          "label": "Vitamin B6",
          "quantity": 50.05282692307692,
          "unit": "%"
        },
        "FOLDFE": {
          "label": "Folate equivalent (total)",
          "quantity": 15.5025625,
          "unit": "%"
        },
        "VITB12": {
          "label": "Vitamin B12",
          "quantity": 2.0116666666666667,
          "unit": "%"
        },
        "VITD": {
          "label": "Vitamin D",
          "quantity": 0,
          "unit": "%"
        },
        "TOCPHA": {
          "label": "Vitamin E",
          "quantity": 7.132633333333334,
          "unit": "%"
        },
        "VITK1": {
          "label": "Vitamin K",
          "quantity": 13.001041666666667,
          "unit": "%"
        }
      },
      "ingredients": [
        {
          "text": "1 cup long-grain white rice",
          "parsed": [
            {
              "quantity": 1,
              "measure": "cup",
              "foodMatch": "white rice",
              "food": "rice",
              "foodId": "food_bpumdjzb5rtqaeabb0kbgbcgr4t9",
              "weight": 195,
              "retainedWeight": 195,
              "nutrients": {
                "RIBF": {
                  "label": "Riboflavin",
                  "quantity": 0.09359999999999999,
                  "unit": "mg"
                },
                "VITD": {
                  "label": "Vitamin D (D2 + D3), International Units",
                  "quantity": 0,
                  "unit": "IU"
                },
                "THIA": {
                  "label": "Thiamin",
                  "quantity": 0.1365,
                  "unit": "mg"
                },
                "FAPU": {
                  "label": "Fatty acids, total polyunsaturated",
                  "quantity": 0.30225,
                  "unit": "g"
                },
                "NIA": {
                  "label": "Niacin",
                  "quantity": 3.12,
                  "unit": "mg"
                },
                "ENERC_KCAL": {
                  "label": "Energy",
                  "quantity": 702,
                  "unit": "kcal"
                },
                "FASAT": {
                  "label": "Fatty acids, total saturated",
                  "quantity": 0.3081,
                  "unit": "g"
                },
                "VITC": {
                  "label": "Vitamin C, total ascorbic acid",
                  "quantity": 0,
                  "unit": "mg"
                },
                "PROCNT": {
                  "label": "Protein",
                  "quantity": 12.8895,
                  "unit": "g"
                },
                "CHOLE": {
                  "label": "Cholesterol",
                  "quantity": 0,
                  "unit": "mg"
                },
                "FAMS": {
                  "label": "Fatty acids, total monounsaturated",
                  "quantity": 0.35295000000000004,
                  "unit": "g"
                },
                "CHOCDF": {
                  "label": "Carbohydrate, by difference",
                  "quantity": 154.635,
                  "unit": "g"
                },
                "FAT": {
                  "label": "Total lipid (fat)",
                  "quantity": 1.131,
                  "unit": "g"
                },
                "VITB6A": {
                  "label": "Vitamin B-6",
                  "quantity": 0.28275,
                  "unit": "mg"
                },
                "VITB12": {
                  "label": "Vitamin B-12",
                  "quantity": 0,
                  "unit": "µg"
                },
                "WATER": {
                  "label": "Water",
                  "quantity": 25.155,
                  "unit": "g"
                },
                "K": {
                  "label": "Potassium, K",
                  "quantity": 167.7,
                  "unit": "mg"
                },
                "P": {
                  "label": "Phosphorus, P",
                  "quantity": 210.6,
                  "unit": "mg"
                },
                "NA": {
                  "label": "Sodium, Na",
                  "quantity": 1.95,
                  "unit": "mg"
                },
                "ZN": {
                  "label": "Zinc, Zn",
                  "quantity": 2.262,
                  "unit": "mg"
                },
                "CA": {
                  "label": "Calcium, Ca",
                  "quantity": 17.55,
                  "unit": "mg"
                },
                "MG": {
                  "label": "Magnesium, Mg",
                  "quantity": 68.25,
                  "unit": "mg"
                },
                "FE": {
                  "label": "Iron, Fe",
                  "quantity": 1.56,
                  "unit": "mg"
                },
                "FOLFD": {
                  "label": "Folate, food",
                  "quantity": 17.55,
                  "unit": "µg"
                },
                "FOLAC": {
                  "label": "Folic acid",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLDFE": {
                  "label": "Folate, DFE",
                  "quantity": 17.55,
                  "unit": "µg"
                }
              },
              "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_cup",
              "status": "OK"
            }
          ]
        },
        {
          "text": "1 3/4 cups chicken broth",
          "parsed": [
            {
              "quantity": 1.75,
              "measure": "cup",
              "foodMatch": "chicken broth",
              "food": "chicken or vegetable stock",
              "foodId": "food_bptblvzambd16nbhewqmhaw1rnh5",
              "weight": 420,
              "retainedWeight": 420,
              "nutrients": {
                "RIBF": {
                  "label": "Riboflavin",
                  "quantity": 0.35700000000000004,
                  "unit": "mg"
                },
                "VITD": {
                  "label": "Vitamin D (D2 + D3), International Units",
                  "quantity": 0,
                  "unit": "IU"
                },
                "THIA": {
                  "label": "Thiamin",
                  "quantity": 0.14700000000000002,
                  "unit": "mg"
                },
                "FAPU": {
                  "label": "Fatty acids, total polyunsaturated",
                  "quantity": 0.8946,
                  "unit": "g"
                },
                "NIA": {
                  "label": "Niacin",
                  "quantity": 6.636,
                  "unit": "mg"
                },
                "ENERC_KCAL": {
                  "label": "Energy",
                  "quantity": 151.2,
                  "unit": "kcal"
                },
                "FASAT": {
                  "label": "Fatty acids, total saturated",
                  "quantity": 1.3481999999999998,
                  "unit": "g"
                },
                "VITA_RAE": {
                  "label": "Vitamin A, RAE",
                  "quantity": 4.2,
                  "unit": "µg"
                },
                "VITC": {
                  "label": "Vitamin C, total ascorbic acid",
                  "quantity": 0.84,
                  "unit": "mg"
                },
                "PROCNT": {
                  "label": "Protein",
                  "quantity": 10.584000000000001,
                  "unit": "g"
                },
                "TOCPHA": {
                  "label": "Vitamin E (alpha-tocopherol)",
                  "quantity": 0.126,
                  "unit": "mg"
                },
                "CHOLE": {
                  "label": "Cholesterol",
                  "quantity": 12.6,
                  "unit": "mg"
                },
                "FAMS": {
                  "label": "Fatty acids, total monounsaturated",
                  "quantity": 2.4444,
                  "unit": "g"
                },
                "CHOCDF": {
                  "label": "Carbohydrate, by difference",
                  "quantity": 14.825999999999999,
                  "unit": "g"
                },
                "FAT": {
                  "label": "Total lipid (fat)",
                  "quantity": 5.04,
                  "unit": "g"
                },
                "VITB6A": {
                  "label": "Vitamin B-6",
                  "quantity": 0.2562,
                  "unit": "mg"
                },
                "VITB12": {
                  "label": "Vitamin B-12",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FIBTG": {
                  "label": "Fiber, total dietary",
                  "quantity": 0,
                  "unit": "g"
                },
                "WATER": {
                  "label": "Water",
                  "quantity": 387.24,
                  "unit": "g"
                },
                "K": {
                  "label": "Potassium, K",
                  "quantity": 441,
                  "unit": "mg"
                },
                "P": {
                  "label": "Phosphorus, P",
                  "quantity": 113.4,
                  "unit": "mg"
                },
                "NA": {
                  "label": "Sodium, Na",
                  "quantity": 600.6,
                  "unit": "mg"
                },
                "ZN": {
                  "label": "Zinc, Zn",
                  "quantity": 0.5880000000000001,
                  "unit": "mg"
                },
                "SUGAR": {
                  "label": "Sugars, total including NLEA",
                  "quantity": 6.636,
                  "unit": "g"
                },
                "CA": {
                  "label": "Calcium, Ca",
                  "quantity": 12.6,
                  "unit": "mg"
                },
                "MG": {
                  "label": "Magnesium, Mg",
                  "quantity": 16.8,
                  "unit": "mg"
                },
                "FE": {
                  "label": "Iron, Fe",
                  "quantity": 0.882,
                  "unit": "mg"
                },
                "VITK1": {
                  "label": "Vitamin K (phylloquinone)",
                  "quantity": 0.84,
                  "unit": "µg"
                },
                "FOLFD": {
                  "label": "Folate, food",
                  "quantity": 21,
                  "unit": "µg"
                },
                "FOLAC": {
                  "label": "Folic acid",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLDFE": {
                  "label": "Folate, DFE",
                  "quantity": 21,
                  "unit": "µg"
                }
              },
              "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_cup",
              "status": "OK"
            }
          ]
        },
        {
          "text": "2 tablespoons butter",
          "parsed": [
            {
              "quantity": 2,
              "measure": "tablespoon",
              "foodMatch": "butter",
              "food": "butter",
              "foodId": "food_awz3iefajbk1fwahq9logahmgltj",
              "weight": 28.4,
              "retainedWeight": 28.4,
              "nutrients": {
                "VITD": {
                  "label": "Vitamin D (D2 + D3), International Units",
                  "quantity": 0,
                  "unit": "IU"
                },
                "ENERC_KCAL": {
                  "label": "Energy",
                  "quantity": 203.628,
                  "unit": "kcal"
                },
                "FASAT": {
                  "label": "Fatty acids, total saturated",
                  "quantity": 14.341999999999999,
                  "unit": "g"
                },
                "VITA_RAE": {
                  "label": "Vitamin A, RAE",
                  "quantity": 194.25599999999997,
                  "unit": "µg"
                },
                "PROCNT": {
                  "label": "Protein",
                  "quantity": 0.24139999999999998,
                  "unit": "g"
                },
                "TOCPHA": {
                  "label": "Vitamin E (alpha-tocopherol)",
                  "quantity": 0.6588799999999999,
                  "unit": "mg"
                },
                "CHOLE": {
                  "label": "Cholesterol",
                  "quantity": 61.06,
                  "unit": "mg"
                },
                "CHOCDF": {
                  "label": "Carbohydrate, by difference",
                  "quantity": 0.01704,
                  "unit": "g"
                },
                "FAT": {
                  "label": "Total lipid (fat)",
                  "quantity": 23.0324,
                  "unit": "g"
                },
                "FIBTG": {
                  "label": "Fiber, total dietary",
                  "quantity": 0,
                  "unit": "g"
                },
                "RIBF": {
                  "label": "Riboflavin",
                  "quantity": 0.009656,
                  "unit": "mg"
                },
                "THIA": {
                  "label": "Thiamin",
                  "quantity": 0.0014199999999999998,
                  "unit": "mg"
                },
                "FAPU": {
                  "label": "Fatty acids, total polyunsaturated",
                  "quantity": 0.8548399999999999,
                  "unit": "g"
                },
                "NIA": {
                  "label": "Niacin",
                  "quantity": 0.011928000000000001,
                  "unit": "mg"
                },
                "VITC": {
                  "label": "Vitamin C, total ascorbic acid",
                  "quantity": 0,
                  "unit": "mg"
                },
                "FAMS": {
                  "label": "Fatty acids, total monounsaturated",
                  "quantity": 6.645599999999999,
                  "unit": "g"
                },
                "VITB6A": {
                  "label": "Vitamin B-6",
                  "quantity": 0.000852,
                  "unit": "mg"
                },
                "VITB12": {
                  "label": "Vitamin B-12",
                  "quantity": 0.04828,
                  "unit": "µg"
                },
                "WATER": {
                  "label": "Water",
                  "quantity": 4.6008,
                  "unit": "g"
                },
                "K": {
                  "label": "Potassium, K",
                  "quantity": 6.815999999999999,
                  "unit": "mg"
                },
                "P": {
                  "label": "Phosphorus, P",
                  "quantity": 6.815999999999999,
                  "unit": "mg"
                },
                "NA": {
                  "label": "Sodium, Na",
                  "quantity": 3.1239999999999997,
                  "unit": "mg"
                },
                "ZN": {
                  "label": "Zinc, Zn",
                  "quantity": 0.025559999999999996,
                  "unit": "mg"
                },
                "SUGAR": {
                  "label": "Sugars, total including NLEA",
                  "quantity": 0.01704,
                  "unit": "g"
                },
                "CA": {
                  "label": "Calcium, Ca",
                  "quantity": 6.815999999999999,
                  "unit": "mg"
                },
                "MG": {
                  "label": "Magnesium, Mg",
                  "quantity": 0.568,
                  "unit": "mg"
                },
                "FE": {
                  "label": "Iron, Fe",
                  "quantity": 0.005679999999999999,
                  "unit": "mg"
                },
                "VITK1": {
                  "label": "Vitamin K (phylloquinone)",
                  "quantity": 1.9879999999999998,
                  "unit": "µg"
                },
                "FOLFD": {
                  "label": "Folate, food",
                  "quantity": 0.8519999999999999,
                  "unit": "µg"
                },
                "FOLAC": {
                  "label": "Folic acid",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLDFE": {
                  "label": "Folate, DFE",
                  "quantity": 0.8519999999999999,
                  "unit": "µg"
                }
              },
              "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_tablespoon",
              "status": "OK"
            }
          ]
        },
        {
          "text": "1/4 cup finely chopped onion",
          "parsed": [
            {
              "quantity": 0.25,
              "measure": "cup",
              "foodMatch": "onion",
              "food": "onions",
              "foodId": "food_bmrvi4ob4binw9a5m7l07amlfcoy",
              "weight": 40,
              "retainedWeight": 40,
              "nutrients": {
                "VITD": {
                  "label": "Vitamin D (D2 + D3), International Units",
                  "quantity": 0,
                  "unit": "IU"
                },
                "FATRN": {
                  "label": "Fatty acids, total trans",
                  "quantity": 0,
                  "unit": "g"
                },
                "ENERC_KCAL": {
                  "label": "Energy",
                  "quantity": 16,
                  "unit": "kcal"
                },
                "FASAT": {
                  "label": "Fatty acids, total saturated",
                  "quantity": 0.016800000000000002,
                  "unit": "g"
                },
                "VITA_RAE": {
                  "label": "Vitamin A, RAE",
                  "quantity": 0,
                  "unit": "µg"
                },
                "PROCNT": {
                  "label": "Protein",
                  "quantity": 0.44,
                  "unit": "g"
                },
                "TOCPHA": {
                  "label": "Vitamin E (alpha-tocopherol)",
                  "quantity": 0.008,
                  "unit": "mg"
                },
                "CHOLE": {
                  "label": "Cholesterol",
                  "quantity": 0,
                  "unit": "mg"
                },
                "CHOCDF": {
                  "label": "Carbohydrate, by difference",
                  "quantity": 3.736,
                  "unit": "g"
                },
                "FAT": {
                  "label": "Total lipid (fat)",
                  "quantity": 0.04,
                  "unit": "g"
                },
                "FIBTG": {
                  "label": "Fiber, total dietary",
                  "quantity": 0.68,
                  "unit": "g"
                },
                "RIBF": {
                  "label": "Riboflavin",
                  "quantity": 0.0108,
                  "unit": "mg"
                },
                "THIA": {
                  "label": "Thiamin",
                  "quantity": 0.0184,
                  "unit": "mg"
                },
                "FAPU": {
                  "label": "Fatty acids, total polyunsaturated",
                  "quantity": 0.0068000000000000005,
                  "unit": "g"
                },
                "NIA": {
                  "label": "Niacin",
                  "quantity": 0.046400000000000004,
                  "unit": "mg"
                },
                "VITC": {
                  "label": "Vitamin C, total ascorbic acid",
                  "quantity": 2.96,
                  "unit": "mg"
                },
                "FAMS": {
                  "label": "Fatty acids, total monounsaturated",
                  "quantity": 0.0052,
                  "unit": "g"
                },
                "VITB6A": {
                  "label": "Vitamin B-6",
                  "quantity": 0.048,
                  "unit": "mg"
                },
                "VITB12": {
                  "label": "Vitamin B-12",
                  "quantity": 0,
                  "unit": "µg"
                },
                "WATER": {
                  "label": "Water",
                  "quantity": 35.64,
                  "unit": "g"
                },
                "K": {
                  "label": "Potassium, K",
                  "quantity": 58.4,
                  "unit": "mg"
                },
                "P": {
                  "label": "Phosphorus, P",
                  "quantity": 11.6,
                  "unit": "mg"
                },
                "NA": {
                  "label": "Sodium, Na",
                  "quantity": 1.6,
                  "unit": "mg"
                },
                "ZN": {
                  "label": "Zinc, Zn",
                  "quantity": 0.068,
                  "unit": "mg"
                },
                "SUGAR": {
                  "label": "Sugars, total including NLEA",
                  "quantity": 1.6960000000000002,
                  "unit": "g"
                },
                "CA": {
                  "label": "Calcium, Ca",
                  "quantity": 9.2,
                  "unit": "mg"
                },
                "MG": {
                  "label": "Magnesium, Mg",
                  "quantity": 4,
                  "unit": "mg"
                },
                "FE": {
                  "label": "Iron, Fe",
                  "quantity": 0.084,
                  "unit": "mg"
                },
                "VITK1": {
                  "label": "Vitamin K (phylloquinone)",
                  "quantity": 0.16,
                  "unit": "µg"
                },
                "FOLFD": {
                  "label": "Folate, food",
                  "quantity": 7.6,
                  "unit": "µg"
                },
                "FOLAC": {
                  "label": "Folic acid",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLDFE": {
                  "label": "Folate, DFE",
                  "quantity": 7.6,
                  "unit": "µg"
                }
              },
              "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_cup",
              "status": "OK"
            }
          ]
        },
        {
          "text": "1/4 cup finely chopped carrot",
          "parsed": [
            {
              "quantity": 0.25,
              "measure": "cup",
              "foodMatch": "carrot",
              "food": "carrots",
              "foodId": "food_ai215e5b85pdh5ajd4aafa3w2zm8",
              "weight": 30.5,
              "retainedWeight": 30.5,
              "nutrients": {
                "VITD": {
                  "label": "Vitamin D (D2 + D3), International Units",
                  "quantity": 0,
                  "unit": "IU"
                },
                "FATRN": {
                  "label": "Fatty acids, total trans",
                  "quantity": 0,
                  "unit": "g"
                },
                "ENERC_KCAL": {
                  "label": "Energy",
                  "quantity": 12.505,
                  "unit": "kcal"
                },
                "FASAT": {
                  "label": "Fatty acids, total saturated",
                  "quantity": 0.00976,
                  "unit": "g"
                },
                "VITA_RAE": {
                  "label": "Vitamin A, RAE",
                  "quantity": 254.675,
                  "unit": "µg"
                },
                "PROCNT": {
                  "label": "Protein",
                  "quantity": 0.28365,
                  "unit": "g"
                },
                "TOCPHA": {
                  "label": "Vitamin E (alpha-tocopherol)",
                  "quantity": 0.20130000000000003,
                  "unit": "mg"
                },
                "CHOLE": {
                  "label": "Cholesterol",
                  "quantity": 0,
                  "unit": "mg"
                },
                "CHOCDF": {
                  "label": "Carbohydrate, by difference",
                  "quantity": 2.9219,
                  "unit": "g"
                },
                "FAT": {
                  "label": "Total lipid (fat)",
                  "quantity": 0.07319999999999999,
                  "unit": "g"
                },
                "FIBTG": {
                  "label": "Fiber, total dietary",
                  "quantity": 0.8539999999999999,
                  "unit": "g"
                },
                "RIBF": {
                  "label": "Riboflavin",
                  "quantity": 0.01769,
                  "unit": "mg"
                },
                "THIA": {
                  "label": "Thiamin",
                  "quantity": 0.02013,
                  "unit": "mg"
                },
                "FAPU": {
                  "label": "Fatty acids, total polyunsaturated",
                  "quantity": 0.03111,
                  "unit": "g"
                },
                "NIA": {
                  "label": "Niacin",
                  "quantity": 0.299815,
                  "unit": "mg"
                },
                "VITC": {
                  "label": "Vitamin C, total ascorbic acid",
                  "quantity": 1.7995,
                  "unit": "mg"
                },
                "FAMS": {
                  "label": "Fatty acids, total monounsaturated",
                  "quantity": 0.00366,
                  "unit": "g"
                },
                "VITB6A": {
                  "label": "Vitamin B-6",
                  "quantity": 0.04209,
                  "unit": "mg"
                },
                "VITB12": {
                  "label": "Vitamin B-12",
                  "quantity": 0,
                  "unit": "µg"
                },
                "WATER": {
                  "label": "Water",
                  "quantity": 26.9315,
                  "unit": "g"
                },
                "K": {
                  "label": "Potassium, K",
                  "quantity": 97.6,
                  "unit": "mg"
                },
                "P": {
                  "label": "Phosphorus, P",
                  "quantity": 10.675,
                  "unit": "mg"
                },
                "NA": {
                  "label": "Sodium, Na",
                  "quantity": 21.045,
                  "unit": "mg"
                },
                "ZN": {
                  "label": "Zinc, Zn",
                  "quantity": 0.07319999999999999,
                  "unit": "mg"
                },
                "SUGAR": {
                  "label": "Sugars, total including NLEA",
                  "quantity": 1.4457,
                  "unit": "g"
                },
                "CA": {
                  "label": "Calcium, Ca",
                  "quantity": 10.065,
                  "unit": "mg"
                },
                "MG": {
                  "label": "Magnesium, Mg",
                  "quantity": 3.66,
                  "unit": "mg"
                },
                "FE": {
                  "label": "Iron, Fe",
                  "quantity": 0.0915,
                  "unit": "mg"
                },
                "VITK1": {
                  "label": "Vitamin K (phylloquinone)",
                  "quantity": 4.026,
                  "unit": "µg"
                },
                "FOLFD": {
                  "label": "Folate, food",
                  "quantity": 5.795,
                  "unit": "µg"
                },
                "FOLAC": {
                  "label": "Folic acid",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLDFE": {
                  "label": "Folate, DFE",
                  "quantity": 5.795,
                  "unit": "µg"
                }
              },
              "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_cup",
              "status": "OK"
            }
          ]
        },
        {
          "text": "1/4 cup finely chopped celery",
          "parsed": [
            {
              "quantity": 0.25,
              "measure": "cup",
              "foodMatch": "celery",
              "food": "celery",
              "foodId": "food_bffeoksbyyur8ja4da73ub2xs57g",
              "weight": 25.25,
              "retainedWeight": 25.25,
              "nutrients": {
                "VITD": {
                  "label": "Vitamin D (D2 + D3), International Units",
                  "quantity": 0,
                  "unit": "IU"
                },
                "FATRN": {
                  "label": "Fatty acids, total trans",
                  "quantity": 0,
                  "unit": "g"
                },
                "ENERC_KCAL": {
                  "label": "Energy",
                  "quantity": 3.535,
                  "unit": "kcal"
                },
                "FASAT": {
                  "label": "Fatty acids, total saturated",
                  "quantity": 0.010605,
                  "unit": "g"
                },
                "VITA_RAE": {
                  "label": "Vitamin A, RAE",
                  "quantity": 5.555,
                  "unit": "µg"
                },
                "PROCNT": {
                  "label": "Protein",
                  "quantity": 0.174225,
                  "unit": "g"
                },
                "TOCPHA": {
                  "label": "Vitamin E (alpha-tocopherol)",
                  "quantity": 0.06817500000000001,
                  "unit": "mg"
                },
                "CHOLE": {
                  "label": "Cholesterol",
                  "quantity": 0,
                  "unit": "mg"
                },
                "CHOCDF": {
                  "label": "Carbohydrate, by difference",
                  "quantity": 0.7499250000000001,
                  "unit": "g"
                },
                "FAT": {
                  "label": "Total lipid (fat)",
                  "quantity": 0.042925000000000005,
                  "unit": "g"
                },
                "FIBTG": {
                  "label": "Fiber, total dietary",
                  "quantity": 0.4040000000000001,
                  "unit": "g"
                },
                "RIBF": {
                  "label": "Riboflavin",
                  "quantity": 0.0143925,
                  "unit": "mg"
                },
                "THIA": {
                  "label": "Thiamin",
                  "quantity": 0.0053025,
                  "unit": "mg"
                },
                "FAPU": {
                  "label": "Fatty acids, total polyunsaturated",
                  "quantity": 0.0199475,
                  "unit": "g"
                },
                "NIA": {
                  "label": "Niacin",
                  "quantity": 0.0808,
                  "unit": "mg"
                },
                "VITC": {
                  "label": "Vitamin C, total ascorbic acid",
                  "quantity": 0.7827500000000001,
                  "unit": "mg"
                },
                "FAMS": {
                  "label": "Fatty acids, total monounsaturated",
                  "quantity": 0.00808,
                  "unit": "g"
                },
                "VITB6A": {
                  "label": "Vitamin B-6",
                  "quantity": 0.018684999999999997,
                  "unit": "mg"
                },
                "VITB12": {
                  "label": "Vitamin B-12",
                  "quantity": 0,
                  "unit": "µg"
                },
                "WATER": {
                  "label": "Water",
                  "quantity": 24.088500000000003,
                  "unit": "g"
                },
                "K": {
                  "label": "Potassium, K",
                  "quantity": 65.65,
                  "unit": "mg"
                },
                "P": {
                  "label": "Phosphorus, P",
                  "quantity": 6.06,
                  "unit": "mg"
                },
                "NA": {
                  "label": "Sodium, Na",
                  "quantity": 20.2,
                  "unit": "mg"
                },
                "ZN": {
                  "label": "Zinc, Zn",
                  "quantity": 0.032825,
                  "unit": "mg"
                },
                "SUGAR": {
                  "label": "Sugars, total including NLEA",
                  "quantity": 0.33835,
                  "unit": "g"
                },
                "CA": {
                  "label": "Calcium, Ca",
                  "quantity": 10.1,
                  "unit": "mg"
                },
                "MG": {
                  "label": "Magnesium, Mg",
                  "quantity": 2.7775,
                  "unit": "mg"
                },
                "FE": {
                  "label": "Iron, Fe",
                  "quantity": 0.05050000000000001,
                  "unit": "mg"
                },
                "VITK1": {
                  "label": "Vitamin K (phylloquinone)",
                  "quantity": 7.398250000000001,
                  "unit": "µg"
                },
                "FOLFD": {
                  "label": "Folate, food",
                  "quantity": 9.09,
                  "unit": "µg"
                },
                "FOLAC": {
                  "label": "Folic acid",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLDFE": {
                  "label": "Folate, DFE",
                  "quantity": 9.09,
                  "unit": "µg"
                }
              },
              "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_cup",
              "status": "OK"
            }
          ]
        },
        {
          "text": "1/4 teaspoon salt",
          "parsed": [
            {
              "quantity": 0.25,
              "measure": "teaspoon",
              "foodMatch": "salt",
              "food": "salt",
              "foodId": "food_btxz81db72hwbra2pncvebzzzum9",
              "weight": 1.5,
              "retainedWeight": 1.5,
              "nutrients": {
                "RIBF": {
                  "label": "Riboflavin",
                  "quantity": 0,
                  "unit": "mg"
                },
                "VITD": {
                  "label": "Vitamin D (D2 + D3), International Units",
                  "quantity": 0,
                  "unit": "IU"
                },
                "THIA": {
                  "label": "Thiamin",
                  "quantity": 0,
                  "unit": "mg"
                },
                "FAPU": {
                  "label": "Fatty acids, total polyunsaturated",
                  "quantity": 0,
                  "unit": "g"
                },
                "FATRN": {
                  "label": "Fatty acids, total trans",
                  "quantity": 0,
                  "unit": "g"
                },
                "NIA": {
                  "label": "Niacin",
                  "quantity": 0,
                  "unit": "mg"
                },
                "ENERC_KCAL": {
                  "label": "Energy",
                  "quantity": 0,
                  "unit": "kcal"
                },
                "FASAT": {
                  "label": "Fatty acids, total saturated",
                  "quantity": 0,
                  "unit": "g"
                },
                "VITA_RAE": {
                  "label": "Vitamin A, RAE",
                  "quantity": 0,
                  "unit": "µg"
                },
                "VITC": {
                  "label": "Vitamin C, total ascorbic acid",
                  "quantity": 0,
                  "unit": "mg"
                },
                "PROCNT": {
                  "label": "Protein",
                  "quantity": 0,
                  "unit": "g"
                },
                "TOCPHA": {
                  "label": "Vitamin E (alpha-tocopherol)",
                  "quantity": 0,
                  "unit": "mg"
                },
                "CHOLE": {
                  "label": "Cholesterol",
                  "quantity": 0,
                  "unit": "mg"
                },
                "FAMS": {
                  "label": "Fatty acids, total monounsaturated",
                  "quantity": 0,
                  "unit": "g"
                },
                "CHOCDF": {
                  "label": "Carbohydrate, by difference",
                  "quantity": 0,
                  "unit": "g"
                },
                "FAT": {
                  "label": "Total lipid (fat)",
                  "quantity": 0,
                  "unit": "g"
                },
                "VITB6A": {
                  "label": "Vitamin B-6",
                  "quantity": 0,
                  "unit": "mg"
                },
                "VITB12": {
                  "label": "Vitamin B-12",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FIBTG": {
                  "label": "Fiber, total dietary",
                  "quantity": 0,
                  "unit": "g"
                },
                "WATER": {
                  "label": "Water",
                  "quantity": 0.0030000000000000005,
                  "unit": "g"
                },
                "K": {
                  "label": "Potassium, K",
                  "quantity": 0.12,
                  "unit": "mg"
                },
                "P": {
                  "label": "Phosphorus, P",
                  "quantity": 0,
                  "unit": "mg"
                },
                "NA": {
                  "label": "Sodium, Na",
                  "quantity": 582,
                  "unit": "mg"
                },
                "ZN": {
                  "label": "Zinc, Zn",
                  "quantity": 0.0015000000000000002,
                  "unit": "mg"
                },
                "SUGAR": {
                  "label": "Sugars, total including NLEA",
                  "quantity": 0,
                  "unit": "g"
                },
                "CA": {
                  "label": "Calcium, Ca",
                  "quantity": 0.36,
                  "unit": "mg"
                },
                "MG": {
                  "label": "Magnesium, Mg",
                  "quantity": 0.015,
                  "unit": "mg"
                },
                "FE": {
                  "label": "Iron, Fe",
                  "quantity": 0.0049499999999999995,
                  "unit": "mg"
                },
                "VITK1": {
                  "label": "Vitamin K (phylloquinone)",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLFD": {
                  "label": "Folate, food",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLAC": {
                  "label": "Folic acid",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLDFE": {
                  "label": "Folate, DFE",
                  "quantity": 0,
                  "unit": "µg"
                }
              },
              "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_teaspoon",
              "status": "OK"
            }
          ]
        },
        {
          "text": "1/4 teaspoon black pepper",
          "parsed": [
            {
              "quantity": 0.25,
              "measure": "teaspoon",
              "foodMatch": "black pepper",
              "food": "black pepper",
              "foodId": "food_b6ywzluaaxv02wad7s1r9ag4py89",
              "weight": 0.725,
              "retainedWeight": 0.725,
              "nutrients": {
                "VITD": {
                  "label": "Vitamin D (D2 + D3), International Units",
                  "quantity": 0,
                  "unit": "IU"
                },
                "FATRN": {
                  "label": "Fatty acids, total trans",
                  "quantity": 0,
                  "unit": "g"
                },
                "ENERC_KCAL": {
                  "label": "Energy",
                  "quantity": 1.81975,
                  "unit": "kcal"
                },
                "FASAT": {
                  "label": "Fatty acids, total saturated",
                  "quantity": 0.0100775,
                  "unit": "g"
                },
                "VITA_RAE": {
                  "label": "Vitamin A, RAE",
                  "quantity": 0.19574999999999998,
                  "unit": "µg"
                },
                "PROCNT": {
                  "label": "Protein",
                  "quantity": 0.0754,
                  "unit": "g"
                },
                "TOCPHA": {
                  "label": "Vitamin E (alpha-tocopherol)",
                  "quantity": 0.00754,
                  "unit": "mg"
                },
                "CHOLE": {
                  "label": "Cholesterol",
                  "quantity": 0,
                  "unit": "mg"
                },
                "CHOCDF": {
                  "label": "Carbohydrate, by difference",
                  "quantity": 0.46399999999999997,
                  "unit": "g"
                },
                "FAT": {
                  "label": "Total lipid (fat)",
                  "quantity": 0.023634999999999996,
                  "unit": "g"
                },
                "FIBTG": {
                  "label": "Fiber, total dietary",
                  "quantity": 0.183425,
                  "unit": "g"
                },
                "RIBF": {
                  "label": "Riboflavin",
                  "quantity": 0.001305,
                  "unit": "mg"
                },
                "THIA": {
                  "label": "Thiamin",
                  "quantity": 0.000783,
                  "unit": "mg"
                },
                "FAPU": {
                  "label": "Fatty acids, total polyunsaturated",
                  "quantity": 0.007235500000000001,
                  "unit": "g"
                },
                "NIA": {
                  "label": "Niacin",
                  "quantity": 0.008265,
                  "unit": "mg"
                },
                "VITC": {
                  "label": "Vitamin C, total ascorbic acid",
                  "quantity": 0,
                  "unit": "mg"
                },
                "FAMS": {
                  "label": "Fatty acids, total monounsaturated",
                  "quantity": 0.00535775,
                  "unit": "g"
                },
                "VITB6A": {
                  "label": "Vitamin B-6",
                  "quantity": 0.0021097499999999996,
                  "unit": "mg"
                },
                "VITB12": {
                  "label": "Vitamin B-12",
                  "quantity": 0,
                  "unit": "µg"
                },
                "WATER": {
                  "label": "Water",
                  "quantity": 0.090625,
                  "unit": "g"
                },
                "K": {
                  "label": "Potassium, K",
                  "quantity": 9.6425,
                  "unit": "mg"
                },
                "P": {
                  "label": "Phosphorus, P",
                  "quantity": 1.1455,
                  "unit": "mg"
                },
                "NA": {
                  "label": "Sodium, Na",
                  "quantity": 0.145,
                  "unit": "mg"
                },
                "ZN": {
                  "label": "Zinc, Zn",
                  "quantity": 0.0086275,
                  "unit": "mg"
                },
                "SUGAR": {
                  "label": "Sugars, total including NLEA",
                  "quantity": 0.00464,
                  "unit": "g"
                },
                "CA": {
                  "label": "Calcium, Ca",
                  "quantity": 3.2117500000000003,
                  "unit": "mg"
                },
                "MG": {
                  "label": "Magnesium, Mg",
                  "quantity": 1.23975,
                  "unit": "mg"
                },
                "FE": {
                  "label": "Iron, Fe",
                  "quantity": 0.0703975,
                  "unit": "mg"
                },
                "VITK1": {
                  "label": "Vitamin K (phylloquinone)",
                  "quantity": 1.1889999999999998,
                  "unit": "µg"
                },
                "FOLFD": {
                  "label": "Folate, food",
                  "quantity": 0.12325,
                  "unit": "µg"
                },
                "FOLAC": {
                  "label": "Folic acid",
                  "quantity": 0,
                  "unit": "µg"
                },
                "FOLDFE": {
                  "label": "Folate, DFE",
                  "quantity": 0.12325,
                  "unit": "µg"
                }
              },
              "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_teaspoon",
              "status": "OK"
            }
          ]
        }
      ],
      "cuisineType": [
        "french"
      ],
      "mealType": [
        "lunch/dinner"
      ],
      "dishType": [],
      "totalNutrientsKCal": {
        "ENERC_KCAL": {
          "label": "Energy",
          "quantity": 1090,
          "unit": "kcal"
        },
        "PROCNT_KCAL": {
          "label": "Calories from protein",
          "quantity": 100,
          "unit": "kcal"
        },
        "FAT_KCAL": {
          "label": "Calories from fat",
          "quantity": 269,
          "unit": "kcal"
        },
        "CHOCDF_KCAL": {
          "label": "Calories from carbohydrates",
          "quantity": 721,
          "unit": "kcal"
        }
      }
    }
""".trimIndent()

    val postData = """
        {
          "uri": "http://www.edamam.com/ontologies/edamam.owl#recipe_5b8fb963d76b4f9f9cde49a2b2ceda30",
          "yield": 2,
          "calories": 1486,
          "totalCO2Emissions": 3212.7918224,
          "co2EmissionsClass": "F",
          "totalWeight": 457.368,
          "dietLabels": [
            "BALANCED"
          ],
          "healthLabels": [
            "SUGAR_CONSCIOUS",
            "PEANUT_FREE",
            "TREE_NUT_FREE",
            "SOY_FREE",
            "FISH_FREE",
            "SHELLFISH_FREE",
            "CRUSTACEAN_FREE",
            "CELERY_FREE",
            "MUSTARD_FREE",
            "SESAME_FREE",
            "LUPINE_FREE",
            "MOLLUSK_FREE",
            "ALCOHOL_FREE",
            "NO_OIL_ADDED",
            "NO_SUGAR_ADDED",
            "SULPHITE_FREE"
          ],
          "cautions": [
            "SULFITES"
          ],
          "totalNutrients": {
            "ENERC_KCAL": {
              "label": "Energy",
              "quantity": 1486.3736800000001,
              "unit": "kcal"
            },
            "FAT": {
              "label": "Total lipid (fat)",
              "quantity": 62.204596800000004,
              "unit": "g"
            },
            "FASAT": {
              "label": "Fatty acids, total saturated",
              "quantity": 23.7083552,
              "unit": "g"
            },
            "FATRN": {
              "label": "Fatty acids, total trans",
              "quantity": 0.185,
              "unit": "g"
            },
            "FAMS": {
              "label": "Fatty acids, total monounsaturated",
              "quantity": 23.672769520000003,
              "unit": "g"
            },
            "FAPU": {
              "label": "Fatty acids, total polyunsaturated",
              "quantity": 9.111092639999999,
              "unit": "g"
            },
            "CHOCDF": {
              "label": "Carbohydrate, by difference",
              "quantity": 154.59152,
              "unit": "g"
            },
            "CHOCDF.net": {
              "label": "Carbohydrates (net)",
              "quantity": 147.719416,
              "unit": "g"
            },
            "FIBTG": {
              "label": "Fiber, total dietary",
              "quantity": 6.872104000000001,
              "unit": "g"
            },
            "SUGAR": {
              "label": "Sugars, total including NLEA",
              "quantity": 6.183755199999999,
              "unit": "g"
            },
            "PROCNT": {
              "label": "Protein",
              "quantity": 70.72387200000001,
              "unit": "g"
            },
            "CHOLE": {
              "label": "Cholesterol",
              "quantity": 472,
              "unit": "mg"
            },
            "NA": {
              "label": "Sodium, Na",
              "quantity": 1496.2936,
              "unit": "mg"
            },
            "CA": {
              "label": "Calcium, Ca",
              "quantity": 710.92024,
              "unit": "mg"
            },
            "MG": {
              "label": "Magnesium, Mg",
              "quantity": 156.83928,
              "unit": "mg"
            },
            "K": {
              "label": "Potassium, K",
              "quantity": 873.2543999999999,
              "unit": "mg"
            },
            "FE": {
              "label": "Iron, Fe",
              "quantity": 5.3748328,
              "unit": "mg"
            },
            "ZN": {
              "label": "Zinc, Zn",
              "quantity": 6.7108792,
              "unit": "mg"
            },
            "P": {
              "label": "Phosphorus, P",
              "quantity": 1100.34144,
              "unit": "mg"
            },
            "VITA_RAE": {
              "label": "Vitamin A, RAE",
              "quantity": 274.86936,
              "unit": "µg"
            },
            "VITC": {
              "label": "Vitamin C, total ascorbic acid",
              "quantity": 1.8719999999999999,
              "unit": "mg"
            },
            "THIA": {
              "label": "Thiamin",
              "quantity": 0.52897744,
              "unit": "mg"
            },
            "RIBF": {
              "label": "Riboflavin",
              "quantity": 0.8330624000000001,
              "unit": "mg"
            },
            "NIA": {
              "label": "Niacin",
              "quantity": 7.6880952,
              "unit": "mg"
            },
            "VITB6A": {
              "label": "Vitamin B-6",
              "quantity": 0.84388088,
              "unit": "mg"
            },
            "FOLDFE": {
              "label": "Folate, DFE",
              "quantity": 86.91256000000001,
              "unit": "µg"
            },
            "FOLFD": {
              "label": "Folate, food",
              "quantity": 86.91256000000001,
              "unit": "µg"
            },
            "FOLAC": {
              "label": "Folic acid",
              "quantity": 0,
              "unit": "µg"
            },
            "VITB12": {
              "label": "Vitamin B-12",
              "quantity": 1.9900000000000002,
              "unit": "µg"
            },
            "VITD": {
              "label": "Vitamin D (D2 + D3)",
              "quantity": 2.65,
              "unit": "µg"
            },
            "TOCPHA": {
              "label": "Vitamin E (alpha-tocopherol)",
              "quantity": 1.8290272000000003,
              "unit": "mg"
            },
            "VITK1": {
              "label": "Vitamin K (phylloquinone)",
              "quantity": 3.69552,
              "unit": "µg"
            },
            "WATER": {
              "label": "Water",
              "quantity": 161.387,
              "unit": "g"
            }
          },
          "totalDaily": {
            "ENERC_KCAL": {
              "label": "Energy",
              "quantity": 74.318684,
              "unit": "%"
            },
            "FAT": {
              "label": "Fat",
              "quantity": 95.6993796923077,
              "unit": "%"
            },
            "FASAT": {
              "label": "Saturated",
              "quantity": 118.541776,
              "unit": "%"
            },
            "CHOCDF": {
              "label": "Carbs",
              "quantity": 51.53050666666667,
              "unit": "%"
            },
            "FIBTG": {
              "label": "Fiber",
              "quantity": 27.488416000000008,
              "unit": "%"
            },
            "PROCNT": {
              "label": "Protein",
              "quantity": 141.44774400000003,
              "unit": "%"
            },
            "CHOLE": {
              "label": "Cholesterol",
              "quantity": 157.33333333333334,
              "unit": "%"
            },
            "NA": {
              "label": "Sodium",
              "quantity": 62.34556666666666,
              "unit": "%"
            },
            "CA": {
              "label": "Calcium",
              "quantity": 71.09202400000001,
              "unit": "%"
            },
            "MG": {
              "label": "Magnesium",
              "quantity": 37.342685714285714,
              "unit": "%"
            },
            "K": {
              "label": "Potassium",
              "quantity": 18.579880851063827,
              "unit": "%"
            },
            "FE": {
              "label": "Iron",
              "quantity": 29.860182222222225,
              "unit": "%"
            },
            "ZN": {
              "label": "Zinc",
              "quantity": 61.00799272727272,
              "unit": "%"
            },
            "P": {
              "label": "Phosphorus",
              "quantity": 157.19163428571426,
              "unit": "%"
            },
            "VITA_RAE": {
              "label": "Vitamin A",
              "quantity": 30.54104,
              "unit": "%"
            },
            "VITC": {
              "label": "Vitamin C",
              "quantity": 2.08,
              "unit": "%"
            },
            "THIA": {
              "label": "Thiamin (B1)",
              "quantity": 44.081453333333336,
              "unit": "%"
            },
            "RIBF": {
              "label": "Riboflavin (B2)",
              "quantity": 64.08172307692308,
              "unit": "%"
            },
            "NIA": {
              "label": "Niacin (B3)",
              "quantity": 48.050595,
              "unit": "%"
            },
            "VITB6A": {
              "label": "Vitamin B6",
              "quantity": 64.91391384615385,
              "unit": "%"
            },
            "FOLDFE": {
              "label": "Folate equivalent (total)",
              "quantity": 21.728140000000003,
              "unit": "%"
            },
            "VITB12": {
              "label": "Vitamin B12",
              "quantity": 82.91666666666669,
              "unit": "%"
            },
            "VITD": {
              "label": "Vitamin D",
              "quantity": 17.666666666666668,
              "unit": "%"
            },
            "TOCPHA": {
              "label": "Vitamin E",
              "quantity": 12.193514666666667,
              "unit": "%"
            },
            "VITK1": {
              "label": "Vitamin K",
              "quantity": 3.0796,
              "unit": "%"
            }
          },
          "ingredients": [
            {
              "text": "200g spaghetti",
              "parsed": [
                {
                  "quantity": 200,
                  "measure": "gram",
                  "foodMatch": "spaghetti",
                  "food": "pasta",
                  "foodId": "food_a8hs60uayl5icia1qe8qoba1kwp8",
                  "weight": 200,
                  "retainedWeight": 200,
                  "nutrients": {
                    "VITD": {
                      "label": "Vitamin D (D2 + D3), International Units",
                      "quantity": 0,
                      "unit": "IU"
                    },
                    "FATRN": {
                      "label": "Fatty acids, total trans",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "ENERC_KCAL": {
                      "label": "Energy",
                      "quantity": 742,
                      "unit": "kcal"
                    },
                    "FASAT": {
                      "label": "Fatty acids, total saturated",
                      "quantity": 0.554,
                      "unit": "g"
                    },
                    "VITA_RAE": {
                      "label": "Vitamin A, RAE",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "PROCNT": {
                      "label": "Protein",
                      "quantity": 26,
                      "unit": "g"
                    },
                    "TOCPHA": {
                      "label": "Vitamin E (alpha-tocopherol)",
                      "quantity": 0.22,
                      "unit": "mg"
                    },
                    "CHOLE": {
                      "label": "Cholesterol",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "CHOCDF": {
                      "label": "Carbohydrate, by difference",
                      "quantity": 149.4,
                      "unit": "g"
                    },
                    "FAT": {
                      "label": "Total lipid (fat)",
                      "quantity": 3.02,
                      "unit": "g"
                    },
                    "FIBTG": {
                      "label": "Fiber, total dietary",
                      "quantity": 6.4,
                      "unit": "g"
                    },
                    "RIBF": {
                      "label": "Riboflavin",
                      "quantity": 0.12,
                      "unit": "mg"
                    },
                    "THIA": {
                      "label": "Thiamin",
                      "quantity": 0.18,
                      "unit": "mg"
                    },
                    "FAPU": {
                      "label": "Fatty acids, total polyunsaturated",
                      "quantity": 1.128,
                      "unit": "g"
                    },
                    "NIA": {
                      "label": "Niacin",
                      "quantity": 3.4,
                      "unit": "mg"
                    },
                    "VITC": {
                      "label": "Vitamin C, total ascorbic acid",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "FAMS": {
                      "label": "Fatty acids, total monounsaturated",
                      "quantity": 0.342,
                      "unit": "g"
                    },
                    "VITB6A": {
                      "label": "Vitamin B-6",
                      "quantity": 0.284,
                      "unit": "mg"
                    },
                    "VITB12": {
                      "label": "Vitamin B-12",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "WATER": {
                      "label": "Water",
                      "quantity": 19.8,
                      "unit": "g"
                    },
                    "K": {
                      "label": "Potassium, K",
                      "quantity": 446,
                      "unit": "mg"
                    },
                    "P": {
                      "label": "Phosphorus, P",
                      "quantity": 378,
                      "unit": "mg"
                    },
                    "NA": {
                      "label": "Sodium, Na",
                      "quantity": 12,
                      "unit": "mg"
                    },
                    "ZN": {
                      "label": "Zinc, Zn",
                      "quantity": 2.82,
                      "unit": "mg"
                    },
                    "SUGAR": {
                      "label": "Sugars, total including NLEA",
                      "quantity": 5.34,
                      "unit": "g"
                    },
                    "CA": {
                      "label": "Calcium, Ca",
                      "quantity": 42,
                      "unit": "mg"
                    },
                    "MG": {
                      "label": "Magnesium, Mg",
                      "quantity": 106,
                      "unit": "mg"
                    },
                    "FE": {
                      "label": "Iron, Fe",
                      "quantity": 2.6,
                      "unit": "mg"
                    },
                    "VITK1": {
                      "label": "Vitamin K (phylloquinone)",
                      "quantity": 0.2,
                      "unit": "µg"
                    },
                    "FOLFD": {
                      "label": "Folate, food",
                      "quantity": 36,
                      "unit": "µg"
                    },
                    "FOLAC": {
                      "label": "Folic acid",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLDFE": {
                      "label": "Folate, DFE",
                      "quantity": 36,
                      "unit": "µg"
                    }
                  },
                  "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_gram",
                  "status": "OK"
                }
              ]
            },
            {
              "text": "100g pancetta",
              "parsed": [
                {
                  "quantity": 100,
                  "measure": "gram",
                  "foodMatch": "pancetta",
                  "food": "pancetta",
                  "foodId": "food_aan01koavbb7p5a81qsnfa763n8v",
                  "weight": 100,
                  "retainedWeight": 100,
                  "nutrients": {
                    "VITD": {
                      "label": "Vitamin D (D2 + D3), International Units",
                      "quantity": 16,
                      "unit": "IU"
                    },
                    "FATRN": {
                      "label": "Fatty acids, total trans",
                      "quantity": 0.147,
                      "unit": "g"
                    },
                    "ENERC_KCAL": {
                      "label": "Energy",
                      "quantity": 393,
                      "unit": "kcal"
                    },
                    "FASAT": {
                      "label": "Fatty acids, total saturated",
                      "quantity": 12.6,
                      "unit": "g"
                    },
                    "VITA_RAE": {
                      "label": "Vitamin A, RAE",
                      "quantity": 11,
                      "unit": "µg"
                    },
                    "PROCNT": {
                      "label": "Protein",
                      "quantity": 13.7,
                      "unit": "g"
                    },
                    "TOCPHA": {
                      "label": "Vitamin E (alpha-tocopherol)",
                      "quantity": 0.43,
                      "unit": "mg"
                    },
                    "CHOLE": {
                      "label": "Cholesterol",
                      "quantity": 66,
                      "unit": "mg"
                    },
                    "CHOCDF": {
                      "label": "Carbohydrate, by difference",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "FAT": {
                      "label": "Total lipid (fat)",
                      "quantity": 37.1,
                      "unit": "g"
                    },
                    "FIBTG": {
                      "label": "Fiber, total dietary",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "RIBF": {
                      "label": "Riboflavin",
                      "quantity": 0.081,
                      "unit": "mg"
                    },
                    "THIA": {
                      "label": "Thiamin",
                      "quantity": 0.276,
                      "unit": "mg"
                    },
                    "FAPU": {
                      "label": "Fatty acids, total polyunsaturated",
                      "quantity": 5.76,
                      "unit": "g"
                    },
                    "NIA": {
                      "label": "Niacin",
                      "quantity": 4.02,
                      "unit": "mg"
                    },
                    "VITC": {
                      "label": "Vitamin C, total ascorbic acid",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "FAMS": {
                      "label": "Fatty acids, total monounsaturated",
                      "quantity": 15.9,
                      "unit": "g"
                    },
                    "VITB6A": {
                      "label": "Vitamin B-6",
                      "quantity": 0.266,
                      "unit": "mg"
                    },
                    "VITB12": {
                      "label": "Vitamin B-12",
                      "quantity": 0.5,
                      "unit": "µg"
                    },
                    "WATER": {
                      "label": "Water",
                      "quantity": 46.7,
                      "unit": "g"
                    },
                    "K": {
                      "label": "Potassium, K",
                      "quantity": 201,
                      "unit": "mg"
                    },
                    "P": {
                      "label": "Phosphorus, P",
                      "quantity": 166,
                      "unit": "mg"
                    },
                    "NA": {
                      "label": "Sodium, Na",
                      "quantity": 751,
                      "unit": "mg"
                    },
                    "ZN": {
                      "label": "Zinc, Zn",
                      "quantity": 1.14,
                      "unit": "mg"
                    },
                    "SUGAR": {
                      "label": "Sugars, total including NLEA",
                      "quantity": 0.35,
                      "unit": "g"
                    },
                    "CA": {
                      "label": "Calcium, Ca",
                      "quantity": 6,
                      "unit": "mg"
                    },
                    "MG": {
                      "label": "Magnesium, Mg",
                      "quantity": 13,
                      "unit": "mg"
                    },
                    "FE": {
                      "label": "Iron, Fe",
                      "quantity": 0.38,
                      "unit": "mg"
                    },
                    "VITK1": {
                      "label": "Vitamin K (phylloquinone)",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLFD": {
                      "label": "Folate, food",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLAC": {
                      "label": "Folic acid",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLDFE": {
                      "label": "Folate, DFE",
                      "quantity": 0,
                      "unit": "µg"
                    }
                  },
                  "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_gram",
                  "status": "OK"
                }
              ]
            },
            {
              "text": "2 cloves garlic",
              "parsed": [
                {
                  "quantity": 2,
                  "measure": "clove",
                  "foodMatch": "garlic",
                  "food": "garlic",
                  "foodId": "food_avtcmx6bgjv1jvay6s6stan8dnyp",
                  "weight": 6,
                  "retainedWeight": 6,
                  "nutrients": {
                    "RIBF": {
                      "label": "Riboflavin",
                      "quantity": 0.0066,
                      "unit": "mg"
                    },
                    "VITD": {
                      "label": "Vitamin D (D2 + D3), International Units",
                      "quantity": 0,
                      "unit": "IU"
                    },
                    "THIA": {
                      "label": "Thiamin",
                      "quantity": 0.012000000000000002,
                      "unit": "mg"
                    },
                    "FAPU": {
                      "label": "Fatty acids, total polyunsaturated",
                      "quantity": 0.01494,
                      "unit": "g"
                    },
                    "FATRN": {
                      "label": "Fatty acids, total trans",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "NIA": {
                      "label": "Niacin",
                      "quantity": 0.041999999999999996,
                      "unit": "mg"
                    },
                    "ENERC_KCAL": {
                      "label": "Energy",
                      "quantity": 8.94,
                      "unit": "kcal"
                    },
                    "FASAT": {
                      "label": "Fatty acids, total saturated",
                      "quantity": 0.00534,
                      "unit": "g"
                    },
                    "VITA_RAE": {
                      "label": "Vitamin A, RAE",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "VITC": {
                      "label": "Vitamin C, total ascorbic acid",
                      "quantity": 1.8719999999999999,
                      "unit": "mg"
                    },
                    "PROCNT": {
                      "label": "Protein",
                      "quantity": 0.38160000000000005,
                      "unit": "g"
                    },
                    "TOCPHA": {
                      "label": "Vitamin E (alpha-tocopherol)",
                      "quantity": 0.0048,
                      "unit": "mg"
                    },
                    "CHOLE": {
                      "label": "Cholesterol",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "FAMS": {
                      "label": "Fatty acids, total monounsaturated",
                      "quantity": 0.00066,
                      "unit": "g"
                    },
                    "CHOCDF": {
                      "label": "Carbohydrate, by difference",
                      "quantity": 1.9860000000000002,
                      "unit": "g"
                    },
                    "FAT": {
                      "label": "Total lipid (fat)",
                      "quantity": 0.03,
                      "unit": "g"
                    },
                    "VITB6A": {
                      "label": "Vitamin B-6",
                      "quantity": 0.0744,
                      "unit": "mg"
                    },
                    "VITB12": {
                      "label": "Vitamin B-12",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FIBTG": {
                      "label": "Fiber, total dietary",
                      "quantity": 0.126,
                      "unit": "g"
                    },
                    "WATER": {
                      "label": "Water",
                      "quantity": 3.516,
                      "unit": "g"
                    },
                    "K": {
                      "label": "Potassium, K",
                      "quantity": 24.06,
                      "unit": "mg"
                    },
                    "P": {
                      "label": "Phosphorus, P",
                      "quantity": 9.18,
                      "unit": "mg"
                    },
                    "NA": {
                      "label": "Sodium, Na",
                      "quantity": 1.02,
                      "unit": "mg"
                    },
                    "ZN": {
                      "label": "Zinc, Zn",
                      "quantity": 0.0696,
                      "unit": "mg"
                    },
                    "SUGAR": {
                      "label": "Sugars, total including NLEA",
                      "quantity": 0.06,
                      "unit": "g"
                    },
                    "CA": {
                      "label": "Calcium, Ca",
                      "quantity": 10.86,
                      "unit": "mg"
                    },
                    "MG": {
                      "label": "Magnesium, Mg",
                      "quantity": 1.5,
                      "unit": "mg"
                    },
                    "FE": {
                      "label": "Iron, Fe",
                      "quantity": 0.102,
                      "unit": "mg"
                    },
                    "VITK1": {
                      "label": "Vitamin K (phylloquinone)",
                      "quantity": 0.102,
                      "unit": "µg"
                    },
                    "FOLFD": {
                      "label": "Folate, food",
                      "quantity": 0.18,
                      "unit": "µg"
                    },
                    "FOLAC": {
                      "label": "Folic acid",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLDFE": {
                      "label": "Folate, DFE",
                      "quantity": 0.18,
                      "unit": "µg"
                    }
                  },
                  "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_clove",
                  "status": "OK"
                }
              ]
            },
            {
              "text": "2 large eggs",
              "parsed": [
                {
                  "quantity": 2,
                  "measure": "whole",
                  "foodMatch": "eggs",
                  "food": "egg",
                  "foodId": "food_bhpradua77pk16aipcvzeayg732r",
                  "weight": 100,
                  "retainedWeight": 100,
                  "nutrients": {
                    "VITD": {
                      "label": "Vitamin D (D2 + D3), International Units",
                      "quantity": 82,
                      "unit": "IU"
                    },
                    "FATRN": {
                      "label": "Fatty acids, total trans",
                      "quantity": 0.038,
                      "unit": "g"
                    },
                    "ENERC_KCAL": {
                      "label": "Energy",
                      "quantity": 143,
                      "unit": "kcal"
                    },
                    "FASAT": {
                      "label": "Fatty acids, total saturated",
                      "quantity": 3.13,
                      "unit": "g"
                    },
                    "VITA_RAE": {
                      "label": "Vitamin A, RAE",
                      "quantity": 160,
                      "unit": "µg"
                    },
                    "PROCNT": {
                      "label": "Protein",
                      "quantity": 12.6,
                      "unit": "g"
                    },
                    "TOCPHA": {
                      "label": "Vitamin E (alpha-tocopherol)",
                      "quantity": 1.05,
                      "unit": "mg"
                    },
                    "CHOLE": {
                      "label": "Cholesterol",
                      "quantity": 372,
                      "unit": "mg"
                    },
                    "CHOCDF": {
                      "label": "Carbohydrate, by difference",
                      "quantity": 0.72,
                      "unit": "g"
                    },
                    "FAT": {
                      "label": "Total lipid (fat)",
                      "quantity": 9.51,
                      "unit": "g"
                    },
                    "FIBTG": {
                      "label": "Fiber, total dietary",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "RIBF": {
                      "label": "Riboflavin",
                      "quantity": 0.457,
                      "unit": "mg"
                    },
                    "THIA": {
                      "label": "Thiamin",
                      "quantity": 0.04,
                      "unit": "mg"
                    },
                    "FAPU": {
                      "label": "Fatty acids, total polyunsaturated",
                      "quantity": 1.91,
                      "unit": "g"
                    },
                    "NIA": {
                      "label": "Niacin",
                      "quantity": 0.075,
                      "unit": "mg"
                    },
                    "VITC": {
                      "label": "Vitamin C, total ascorbic acid",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "FAMS": {
                      "label": "Fatty acids, total monounsaturated",
                      "quantity": 3.66,
                      "unit": "g"
                    },
                    "VITB6A": {
                      "label": "Vitamin B-6",
                      "quantity": 0.17,
                      "unit": "mg"
                    },
                    "VITB12": {
                      "label": "Vitamin B-12",
                      "quantity": 0.89,
                      "unit": "µg"
                    },
                    "WATER": {
                      "label": "Water",
                      "quantity": 76.2,
                      "unit": "g"
                    },
                    "K": {
                      "label": "Potassium, K",
                      "quantity": 138,
                      "unit": "mg"
                    },
                    "P": {
                      "label": "Phosphorus, P",
                      "quantity": 198,
                      "unit": "mg"
                    },
                    "NA": {
                      "label": "Sodium, Na",
                      "quantity": 142,
                      "unit": "mg"
                    },
                    "ZN": {
                      "label": "Zinc, Zn",
                      "quantity": 1.29,
                      "unit": "mg"
                    },
                    "SUGAR": {
                      "label": "Sugars, total including NLEA",
                      "quantity": 0.37,
                      "unit": "g"
                    },
                    "CA": {
                      "label": "Calcium, Ca",
                      "quantity": 56,
                      "unit": "mg"
                    },
                    "MG": {
                      "label": "Magnesium, Mg",
                      "quantity": 12,
                      "unit": "mg"
                    },
                    "FE": {
                      "label": "Iron, Fe",
                      "quantity": 1.75,
                      "unit": "mg"
                    },
                    "VITK1": {
                      "label": "Vitamin K (phylloquinone)",
                      "quantity": 0.3,
                      "unit": "µg"
                    },
                    "FOLFD": {
                      "label": "Folate, food",
                      "quantity": 47,
                      "unit": "µg"
                    },
                    "FOLAC": {
                      "label": "Folic acid",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLDFE": {
                      "label": "Folate, DFE",
                      "quantity": 47,
                      "unit": "µg"
                    }
                  },
                  "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_unit",
                  "status": "OK"
                }
              ]
            },
            {
              "text": "50g Parmesan cheese",
              "parsed": [
                {
                  "quantity": 50,
                  "measure": "gram",
                  "foodMatch": "Parmesan cheese",
                  "food": "parmesan cheese",
                  "foodId": "food_a104ppxa06d3emb272fkcab3cugd",
                  "weight": 50,
                  "retainedWeight": 50,
                  "nutrients": {
                    "RIBF": {
                      "label": "Riboflavin",
                      "quantity": 0.166,
                      "unit": "mg"
                    },
                    "VITD": {
                      "label": "Vitamin D (D2 + D3), International Units",
                      "quantity": 9.5,
                      "unit": "IU"
                    },
                    "THIA": {
                      "label": "Thiamin",
                      "quantity": 0.0195,
                      "unit": "mg"
                    },
                    "FAPU": {
                      "label": "Fatty acids, total polyunsaturated",
                      "quantity": 0.2845,
                      "unit": "g"
                    },
                    "NIA": {
                      "label": "Niacin",
                      "quantity": 0.1355,
                      "unit": "mg"
                    },
                    "ENERC_KCAL": {
                      "label": "Energy",
                      "quantity": 196,
                      "unit": "kcal"
                    },
                    "FASAT": {
                      "label": "Fatty acids, total saturated",
                      "quantity": 7.4,
                      "unit": "g"
                    },
                    "VITA_RAE": {
                      "label": "Vitamin A, RAE",
                      "quantity": 103.5,
                      "unit": "µg"
                    },
                    "VITC": {
                      "label": "Vitamin C, total ascorbic acid",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "PROCNT": {
                      "label": "Protein",
                      "quantity": 17.9,
                      "unit": "g"
                    },
                    "TOCPHA": {
                      "label": "Vitamin E (alpha-tocopherol)",
                      "quantity": 0.11,
                      "unit": "mg"
                    },
                    "CHOLE": {
                      "label": "Cholesterol",
                      "quantity": 34,
                      "unit": "mg"
                    },
                    "FAMS": {
                      "label": "Fatty acids, total monounsaturated",
                      "quantity": 3.76,
                      "unit": "g"
                    },
                    "CHOCDF": {
                      "label": "Carbohydrate, by difference",
                      "quantity": 1.61,
                      "unit": "g"
                    },
                    "FAT": {
                      "label": "Total lipid (fat)",
                      "quantity": 12.5,
                      "unit": "g"
                    },
                    "VITB6A": {
                      "label": "Vitamin B-6",
                      "quantity": 0.0455,
                      "unit": "mg"
                    },
                    "VITB12": {
                      "label": "Vitamin B-12",
                      "quantity": 0.6,
                      "unit": "µg"
                    },
                    "FIBTG": {
                      "label": "Fiber, total dietary",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "WATER": {
                      "label": "Water",
                      "quantity": 15,
                      "unit": "g"
                    },
                    "K": {
                      "label": "Potassium, K",
                      "quantity": 46,
                      "unit": "mg"
                    },
                    "P": {
                      "label": "Phosphorus, P",
                      "quantity": 347,
                      "unit": "mg"
                    },
                    "NA": {
                      "label": "Sodium, Na",
                      "quantity": 590,
                      "unit": "mg"
                    },
                    "ZN": {
                      "label": "Zinc, Zn",
                      "quantity": 1.375,
                      "unit": "mg"
                    },
                    "SUGAR": {
                      "label": "Sugars, total including NLEA",
                      "quantity": 0.055,
                      "unit": "g"
                    },
                    "CA": {
                      "label": "Calcium, Ca",
                      "quantity": 590,
                      "unit": "mg"
                    },
                    "MG": {
                      "label": "Magnesium, Mg",
                      "quantity": 22,
                      "unit": "mg"
                    },
                    "FE": {
                      "label": "Iron, Fe",
                      "quantity": 0.41,
                      "unit": "mg"
                    },
                    "VITK1": {
                      "label": "Vitamin K (phylloquinone)",
                      "quantity": 0.85,
                      "unit": "µg"
                    },
                    "FOLFD": {
                      "label": "Folate, food",
                      "quantity": 3.5,
                      "unit": "µg"
                    },
                    "FOLAC": {
                      "label": "Folic acid",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLDFE": {
                      "label": "Folate, DFE",
                      "quantity": 3.5,
                      "unit": "µg"
                    }
                  },
                  "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_gram",
                  "status": "OK"
                }
              ]
            },
            {
              "text": "Salt and pepper to taste",
              "parsed": [
                {
                  "quantity": 0,
                  "foodMatch": "Salt",
                  "food": "salt",
                  "foodId": "food_btxz81db72hwbra2pncvebzzzum9",
                  "weight": 2.736,
                  "retainedWeight": 0,
                  "nutrients": {
                    "RIBF": {
                      "label": "Riboflavin",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "VITD": {
                      "label": "Vitamin D (D2 + D3), International Units",
                      "quantity": 0,
                      "unit": "IU"
                    },
                    "THIA": {
                      "label": "Thiamin",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "FAPU": {
                      "label": "Fatty acids, total polyunsaturated",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "FATRN": {
                      "label": "Fatty acids, total trans",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "NIA": {
                      "label": "Niacin",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "ENERC_KCAL": {
                      "label": "Energy",
                      "quantity": 0,
                      "unit": "kcal"
                    },
                    "FASAT": {
                      "label": "Fatty acids, total saturated",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "VITA_RAE": {
                      "label": "Vitamin A, RAE",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "VITC": {
                      "label": "Vitamin C, total ascorbic acid",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "PROCNT": {
                      "label": "Protein",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "TOCPHA": {
                      "label": "Vitamin E (alpha-tocopherol)",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "CHOLE": {
                      "label": "Cholesterol",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "FAMS": {
                      "label": "Fatty acids, total monounsaturated",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "CHOCDF": {
                      "label": "Carbohydrate, by difference",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "FAT": {
                      "label": "Total lipid (fat)",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "VITB6A": {
                      "label": "Vitamin B-6",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "VITB12": {
                      "label": "Vitamin B-12",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FIBTG": {
                      "label": "Fiber, total dietary",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "WATER": {
                      "label": "Water",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "K": {
                      "label": "Potassium, K",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "P": {
                      "label": "Phosphorus, P",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "NA": {
                      "label": "Sodium, Na",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "ZN": {
                      "label": "Zinc, Zn",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "SUGAR": {
                      "label": "Sugars, total including NLEA",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "CA": {
                      "label": "Calcium, Ca",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "MG": {
                      "label": "Magnesium, Mg",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "FE": {
                      "label": "Iron, Fe",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "VITK1": {
                      "label": "Vitamin K (phylloquinone)",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLFD": {
                      "label": "Folate, food",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLAC": {
                      "label": "Folic acid",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLDFE": {
                      "label": "Folate, DFE",
                      "quantity": 0,
                      "unit": "µg"
                    }
                  },
                  "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_default",
                  "status": "OK"
                },
                {
                  "quantity": 0,
                  "foodMatch": "pepper",
                  "food": "black pepper",
                  "foodId": "food_b6ywzluaaxv02wad7s1r9ag4py89",
                  "weight": 1.368,
                  "retainedWeight": 1.368,
                  "nutrients": {
                    "VITD": {
                      "label": "Vitamin D (D2 + D3), International Units",
                      "quantity": 0,
                      "unit": "IU"
                    },
                    "FATRN": {
                      "label": "Fatty acids, total trans",
                      "quantity": 0,
                      "unit": "g"
                    },
                    "ENERC_KCAL": {
                      "label": "Energy",
                      "quantity": 3.4336800000000007,
                      "unit": "kcal"
                    },
                    "FASAT": {
                      "label": "Fatty acids, total saturated",
                      "quantity": 0.0190152,
                      "unit": "g"
                    },
                    "VITA_RAE": {
                      "label": "Vitamin A, RAE",
                      "quantity": 0.36936,
                      "unit": "µg"
                    },
                    "PROCNT": {
                      "label": "Protein",
                      "quantity": 0.142272,
                      "unit": "g"
                    },
                    "TOCPHA": {
                      "label": "Vitamin E (alpha-tocopherol)",
                      "quantity": 0.014227200000000002,
                      "unit": "mg"
                    },
                    "CHOLE": {
                      "label": "Cholesterol",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "CHOCDF": {
                      "label": "Carbohydrate, by difference",
                      "quantity": 0.8755200000000001,
                      "unit": "g"
                    },
                    "FAT": {
                      "label": "Total lipid (fat)",
                      "quantity": 0.0445968,
                      "unit": "g"
                    },
                    "FIBTG": {
                      "label": "Fiber, total dietary",
                      "quantity": 0.3461040000000001,
                      "unit": "g"
                    },
                    "RIBF": {
                      "label": "Riboflavin",
                      "quantity": 0.0024624,
                      "unit": "mg"
                    },
                    "THIA": {
                      "label": "Thiamin",
                      "quantity": 0.0014774400000000002,
                      "unit": "mg"
                    },
                    "FAPU": {
                      "label": "Fatty acids, total polyunsaturated",
                      "quantity": 0.01365264,
                      "unit": "g"
                    },
                    "NIA": {
                      "label": "Niacin",
                      "quantity": 0.0155952,
                      "unit": "mg"
                    },
                    "VITC": {
                      "label": "Vitamin C, total ascorbic acid",
                      "quantity": 0,
                      "unit": "mg"
                    },
                    "FAMS": {
                      "label": "Fatty acids, total monounsaturated",
                      "quantity": 0.01010952,
                      "unit": "g"
                    },
                    "VITB6A": {
                      "label": "Vitamin B-6",
                      "quantity": 0.00398088,
                      "unit": "mg"
                    },
                    "VITB12": {
                      "label": "Vitamin B-12",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "WATER": {
                      "label": "Water",
                      "quantity": 0.171,
                      "unit": "g"
                    },
                    "K": {
                      "label": "Potassium, K",
                      "quantity": 18.1944,
                      "unit": "mg"
                    },
                    "P": {
                      "label": "Phosphorus, P",
                      "quantity": 2.1614400000000002,
                      "unit": "mg"
                    },
                    "NA": {
                      "label": "Sodium, Na",
                      "quantity": 0.2736,
                      "unit": "mg"
                    },
                    "ZN": {
                      "label": "Zinc, Zn",
                      "quantity": 0.0162792,
                      "unit": "mg"
                    },
                    "SUGAR": {
                      "label": "Sugars, total including NLEA",
                      "quantity": 0.008755200000000001,
                      "unit": "g"
                    },
                    "CA": {
                      "label": "Calcium, Ca",
                      "quantity": 6.06024,
                      "unit": "mg"
                    },
                    "MG": {
                      "label": "Magnesium, Mg",
                      "quantity": 2.3392800000000005,
                      "unit": "mg"
                    },
                    "FE": {
                      "label": "Iron, Fe",
                      "quantity": 0.1328328,
                      "unit": "mg"
                    },
                    "VITK1": {
                      "label": "Vitamin K (phylloquinone)",
                      "quantity": 2.24352,
                      "unit": "µg"
                    },
                    "FOLFD": {
                      "label": "Folate, food",
                      "quantity": 0.23256,
                      "unit": "µg"
                    },
                    "FOLAC": {
                      "label": "Folic acid",
                      "quantity": 0,
                      "unit": "µg"
                    },
                    "FOLDFE": {
                      "label": "Folate, DFE",
                      "quantity": 0.23256,
                      "unit": "µg"
                    }
                  },
                  "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_default",
                  "status": "OK"
                }
              ]
            }
          ],
          "cuisineType": [
            "italian"
          ],
          "mealType": [
            "lunch/dinner"
          ],
          "dishType": [
            "main course"
          ],
          "totalNutrientsKCal": {
            "ENERC_KCAL": {
              "label": "Energy",
              "quantity": 1487,
              "unit": "kcal"
            },
            "PROCNT_KCAL": {
              "label": "Calories from protein",
              "quantity": 288,
              "unit": "kcal"
            },
            "FAT_KCAL": {
              "label": "Calories from fat",
              "quantity": 570,
              "unit": "kcal"
            },
            "CHOCDF_KCAL": {
              "label": "Calories from carbohydrates",
              "quantity": 629,
              "unit": "kcal"
            }
          }
        }
    """.trimIndent()

    val dosaData = """
        {
          "uri": "http://www.edamam.com/ontologies/edamam.owl#recipe_a37c0f2ff90a40bda778a76cc3113636",
          "calories": 349,
          "totalCO2Emissions": 241.78,
          "co2EmissionsClass": "B",
          "totalWeight": 154,
          "dietLabels": [
            "BALANCED"
          ],
          "healthLabels": [
            "SUGAR_CONSCIOUS",
            "LOW_SUGAR",
            "LOW_POTASSIUM",
            "KIDNEY_FRIENDLY",
            "VEGETARIAN",
            "PESCATARIAN",
            "MEDITERRANEAN",
            "PEANUT_FREE",
            "TREE_NUT_FREE",
            "SOY_FREE",
            "FISH_FREE",
            "SHELLFISH_FREE",
            "PORK_FREE",
            "RED_MEAT_FREE",
            "CRUSTACEAN_FREE",
            "CELERY_FREE",
            "MUSTARD_FREE",
            "SESAME_FREE",
            "LUPINE_FREE",
            "MOLLUSK_FREE",
            "ALCOHOL_FREE",
            "SULPHITE_FREE",
            "KOSHER"
          ],
          "cautions": [],
          "totalNutrients": {
            "ENERC_KCAL": {
              "label": "Energy",
              "quantity": 349.58,
              "unit": "kcal"
            },
            "FAT": {
              "label": "Total lipid (fat)",
              "quantity": 14.937999999999999,
              "unit": "g"
            },
            "FASAT": {
              "label": "Fatty acids, total saturated",
              "quantity": 3.2648,
              "unit": "g"
            },
            "FAMS": {
              "label": "Fatty acids, total monounsaturated",
              "quantity": 3.8038000000000003,
              "unit": "g"
            },
            "FAPU": {
              "label": "Fatty acids, total polyunsaturated",
              "quantity": 6.853000000000001,
              "unit": "g"
            },
            "CHOCDF": {
              "label": "Carbohydrate, by difference",
              "quantity": 43.582,
              "unit": "g"
            },
            "CHOCDF.net": {
              "label": "Carbohydrates (net)",
              "quantity": 43.582,
              "unit": "g"
            },
            "PROCNT": {
              "label": "Protein",
              "quantity": 9.856000000000002,
              "unit": "g"
            },
            "CHOLE": {
              "label": "Cholesterol",
              "quantity": 90.86,
              "unit": "mg"
            },
            "NA": {
              "label": "Sodium, Na",
              "quantity": 676.0600000000001,
              "unit": "mg"
            },
            "CA": {
              "label": "Calcium, Ca",
              "quantity": 337.26,
              "unit": "mg"
            },
            "MG": {
              "label": "Magnesium, Mg",
              "quantity": 24.64,
              "unit": "mg"
            },
            "K": {
              "label": "Potassium, K",
              "quantity": 203.28,
              "unit": "mg"
            },
            "FE": {
              "label": "Iron, Fe",
              "quantity": 2.7720000000000002,
              "unit": "mg"
            },
            "ZN": {
              "label": "Zinc, Zn",
              "quantity": 0.8624,
              "unit": "mg"
            },
            "P": {
              "label": "Phosphorus, P",
              "quantity": 244.86,
              "unit": "mg"
            },
            "VITA_RAE": {
              "label": "Vitamin A, RAE",
              "quantity": 83.16,
              "unit": "µg"
            },
            "VITC": {
              "label": "Vitamin C, total ascorbic acid",
              "quantity": 0.46199999999999997,
              "unit": "mg"
            },
            "THIA": {
              "label": "Thiamin",
              "quantity": 0.30954000000000004,
              "unit": "mg"
            },
            "RIBF": {
              "label": "Riboflavin",
              "quantity": 0.43274000000000007,
              "unit": "mg"
            },
            "NIA": {
              "label": "Niacin",
              "quantity": 2.4178,
              "unit": "mg"
            },
            "VITB6A": {
              "label": "Vitamin B-6",
              "quantity": 0.07084,
              "unit": "mg"
            },
            "FOLDFE": {
              "label": "Folate, DFE",
              "quantity": 86.24000000000001,
              "unit": "µg"
            },
            "FOLFD": {
              "label": "Folate, food",
              "quantity": 18.48,
              "unit": "µg"
            },
            "FOLAC": {
              "label": "Folic acid",
              "quantity": 40.04,
              "unit": "µg"
            },
            "VITB12": {
              "label": "Vitamin B-12",
              "quantity": 0.3388,
              "unit": "µg"
            },
            "WATER": {
              "label": "Water",
              "quantity": 81.466,
              "unit": "g"
            }
          },
          "totalDaily": {
            "ENERC_KCAL": {
              "label": "Energy",
              "quantity": 17.479,
              "unit": "%"
            },
            "FAT": {
              "label": "Fat",
              "quantity": 22.98153846153846,
              "unit": "%"
            },
            "FASAT": {
              "label": "Saturated",
              "quantity": 16.324,
              "unit": "%"
            },
            "CHOCDF": {
              "label": "Carbs",
              "quantity": 14.527333333333333,
              "unit": "%"
            },
            "PROCNT": {
              "label": "Protein",
              "quantity": 19.712000000000003,
              "unit": "%"
            },
            "CHOLE": {
              "label": "Cholesterol",
              "quantity": 30.286666666666665,
              "unit": "%"
            },
            "NA": {
              "label": "Sodium",
              "quantity": 28.169166666666666,
              "unit": "%"
            },
            "CA": {
              "label": "Calcium",
              "quantity": 33.726,
              "unit": "%"
            },
            "MG": {
              "label": "Magnesium",
              "quantity": 5.866666666666666,
              "unit": "%"
            },
            "K": {
              "label": "Potassium",
              "quantity": 4.325106382978723,
              "unit": "%"
            },
            "FE": {
              "label": "Iron",
              "quantity": 15.400000000000002,
              "unit": "%"
            },
            "ZN": {
              "label": "Zinc",
              "quantity": 7.840000000000001,
              "unit": "%"
            },
            "P": {
              "label": "Phosphorus",
              "quantity": 34.98,
              "unit": "%"
            },
            "VITA_RAE": {
              "label": "Vitamin A",
              "quantity": 9.24,
              "unit": "%"
            },
            "VITC": {
              "label": "Vitamin C",
              "quantity": 0.5133333333333333,
              "unit": "%"
            },
            "THIA": {
              "label": "Thiamin (B1)",
              "quantity": 25.795000000000005,
              "unit": "%"
            },
            "RIBF": {
              "label": "Riboflavin (B2)",
              "quantity": 33.28769230769231,
              "unit": "%"
            },
            "NIA": {
              "label": "Niacin (B3)",
              "quantity": 15.111250000000002,
              "unit": "%"
            },
            "VITB6A": {
              "label": "Vitamin B6",
              "quantity": 5.449230769230769,
              "unit": "%"
            },
            "FOLDFE": {
              "label": "Folate equivalent (total)",
              "quantity": 21.56,
              "unit": "%"
            },
            "VITB12": {
              "label": "Vitamin B12",
              "quantity": 14.116666666666665,
              "unit": "%"
            }
          },
          "ingredients": [
            {
              "text": "2 dosa",
              "parsed": [
                {
                  "quantity": 2,
                  "measure": "whole",
                  "foodMatch": "dosa",
                  "food": "pancake",
                  "foodId": "food_avvt0qpbghypnvaqlos9zb1s5l8h",
                  "weight": 154,
                  "retainedWeight": 154,
                  "nutrients": {
                    "RIBF": {
                      "label": "Riboflavin",
                      "quantity": 0.43274,
                      "unit": "mg"
                    },
                    "THIA": {
                      "label": "Thiamin",
                      "quantity": 0.30954,
                      "unit": "mg"
                    },
                    "FAPU": {
                      "label": "Fatty acids, total polyunsaturated",
                      "quantity": 6.853000000000001,
                      "unit": "g"
                    },
                    "NIA": {
                      "label": "Niacin",
                      "quantity": 2.4178,
                      "unit": "mg"
                    },
                    "ENERC_KCAL": {
                      "label": "Energy",
                      "quantity": 349.58,
                      "unit": "kcal"
                    },
                    "FASAT": {
                      "label": "Fatty acids, total saturated",
                      "quantity": 3.2648,
                      "unit": "g"
                    },
                    "VITA_RAE": {
                      "label": "Vitamin A, RAE",
                      "quantity": 83.16,
                      "unit": "µg"
                    },
                    "VITC": {
                      "label": "Vitamin C, total ascorbic acid",
                      "quantity": 0.46199999999999997,
                      "unit": "mg"
                    },
                    "PROCNT": {
                      "label": "Protein",
                      "quantity": 9.856,
                      "unit": "g"
                    },
                    "CHOLE": {
                      "label": "Cholesterol",
                      "quantity": 90.86,
                      "unit": "mg"
                    },
                    "FAMS": {
                      "label": "Fatty acids, total monounsaturated",
                      "quantity": 3.8038000000000007,
                      "unit": "g"
                    },
                    "CHOCDF": {
                      "label": "Carbohydrate, by difference",
                      "quantity": 43.582,
                      "unit": "g"
                    },
                    "FAT": {
                      "label": "Total lipid (fat)",
                      "quantity": 14.937999999999999,
                      "unit": "g"
                    },
                    "VITB6A": {
                      "label": "Vitamin B-6",
                      "quantity": 0.07084,
                      "unit": "mg"
                    },
                    "VITB12": {
                      "label": "Vitamin B-12",
                      "quantity": 0.33880000000000005,
                      "unit": "µg"
                    },
                    "WATER": {
                      "label": "Water",
                      "quantity": 81.466,
                      "unit": "g"
                    },
                    "K": {
                      "label": "Potassium, K",
                      "quantity": 203.28,
                      "unit": "mg"
                    },
                    "P": {
                      "label": "Phosphorus, P",
                      "quantity": 244.86,
                      "unit": "mg"
                    },
                    "NA": {
                      "label": "Sodium, Na",
                      "quantity": 676.06,
                      "unit": "mg"
                    },
                    "ZN": {
                      "label": "Zinc, Zn",
                      "quantity": 0.8624,
                      "unit": "mg"
                    },
                    "CA": {
                      "label": "Calcium, Ca",
                      "quantity": 337.26,
                      "unit": "mg"
                    },
                    "MG": {
                      "label": "Magnesium, Mg",
                      "quantity": 24.64,
                      "unit": "mg"
                    },
                    "FE": {
                      "label": "Iron, Fe",
                      "quantity": 2.772,
                      "unit": "mg"
                    },
                    "FOLFD": {
                      "label": "Folate, food",
                      "quantity": 18.48,
                      "unit": "µg"
                    },
                    "FOLAC": {
                      "label": "Folic acid",
                      "quantity": 40.04,
                      "unit": "µg"
                    },
                    "FOLDFE": {
                      "label": "Folate, DFE",
                      "quantity": 86.24,
                      "unit": "µg"
                    }
                  },
                  "measureURI": "http://www.edamam.com/ontologies/edamam.owl#Measure_unit",
                  "status": "OK"
                }
              ]
            }
          ],
          "totalNutrientsKCal": {
            "ENERC_KCAL": {
              "label": "Energy",
              "quantity": 350,
              "unit": "kcal"
            },
            "PROCNT_KCAL": {
              "label": "Calories from protein",
              "quantity": 40,
              "unit": "kcal"
            },
            "FAT_KCAL": {
              "label": "Calories from fat",
              "quantity": 135,
              "unit": "kcal"
            },
            "CHOCDF_KCAL": {
              "label": "Calories from carbohydrates",
              "quantity": 175,
              "unit": "kcal"
            }
          }
        }
    """.trimIndent()
    const val appId = "f384e011"
    const val appKey = "becbe3a43bf9dc60739a54e512f841c8"
    const val baseUrl = "https://api.edamam.com/"
}
