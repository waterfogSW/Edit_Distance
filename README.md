# Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

- Insert a character : cost = 1
- Delete a character : cost = 1
- Replace a character
  - if replacing character is **same** : cost = 0
  - else : cost = 2

## Usage

- Input 2 word to get cost of edit
- Find minimum number of edits (operations) required to convert ‘**String 1**’ into ‘**String 2**’.  

## Examples

### Case 1
| String 1 | String 2 |
| -------- | -------- |
| aabab    | babb     |

![image](https://user-images.githubusercontent.com/28651727/117564172-bffd9b00-b0e5-11eb-9b90-1644118740d2.png)

### Case 2
| String 1 | String 2 |
| -------- | -------- |
| san      | sun      |

![image](https://user-images.githubusercontent.com/28651727/117565128-bcb8de00-b0ea-11eb-9265-5d5b5bdad889.png)

### Case 3
| String 1 | String 2 |
| -------- | -------- |
| sunday   | saturday |

![image](https://user-images.githubusercontent.com/28651727/117565045-5207a280-b0ea-11eb-9842-35fc7ce4e15f.png)

### Case 4
| String 1 | String 2 |
| -------- | -------- |
| food     | money    |

![image](https://user-images.githubusercontent.com/28651727/117565089-8bd8a900-b0ea-11eb-8947-f48109dbd3ed.png)


### Case 5
| String 1  | String 2   |
| --------- | ---------- |
| voldemort | dumbledore |

![image](https://user-images.githubusercontent.com/28651727/117565113-a1e66980-b0ea-11eb-934e-18c7fce388a5.png)