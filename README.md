# text-editor
A text editor which includes features such as autocomplete, spelling correction, and calculation of Flesch readability score.

Completed a series of modules to build this text editor as part of the Data Structures and Performance certification course through UC San Diego. Largely developed the back-end functionality of the text editor.

Module 1: Implementing Flesch readability score in a basic way.

1: Implemented getNumSentences(), getNumWords(), and getNumSyllables() methods in BasicDocument, and countSyllables() in Document.

2: Used these methods to calculate Flesch readability score.

Module 2: Implementing Flesch readability score in more advanced way, and comparing implementations.

1: Implemented processText(), getNumSentences(), getNumWords(), and getNumSyllables in EfficientDocument.

2: Calculated Big-O run time of BasicDocument and EfficientDocument to calculate Flesch score. Performed benchmarking tests to compare implementations.

Module 3: Implementing and Testing a Doubly Linked List

1: Implemented the linked list constructor.

2: Implemented the methods public E get(int index), public boolean add(E element).

3: Ran JUnit tests for previously implemented methods.

4: Implemented methods public int size(), public void add(int index, E element), public E remove(int index), public E set(int index, E element), in MyLinkedList.

Module 4: Spell checking and autocomplete.

1: Implemented the DictionaryLL class which implements the Dictionary interface.

2: Implemented the DictionaryBST class which implements the Dictionary interface.

3: Compared the running time of each data structure in the worst case scenario where a word is not in the dictionary using DictionaryBenchmarking class.

4: *Implementing Trie Data Structure* Implemented methods public boolean addWord(String word), public int size(), public boolean isWord(String s), public List<String> predictCompletions(String prefix, int numCompletions) in AutoCompleteDictionaryTrie.

Module 5: Spelling Suggestions

1: Implemented methods public void substitution(String s, List<String> currentList, boolean wordsOnly), public void insertions(String s, List<String> currentList, boolean wordsOnly ), public void deletions(String s, List<String> currentList, boolean wordsOnly ) in NearbyWords.

2: Implemented method public List<String> suggestions(String word, int numSuggestions) in NearbyWords.

Final Course Grade: 100%





