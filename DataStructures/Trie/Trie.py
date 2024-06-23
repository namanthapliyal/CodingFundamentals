class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = True

    def search(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                return False
            node = node.children[char]
        return node.is_end_of_word

    def starts_with(self, prefix):
        node = self.root
        for char in prefix:
            if char not in node.children:
                return False
            node = node.children[char]
        return True


# Create a Trie
trie = Trie()

# Insert words into the Trie
trie.insert("apple")
trie.insert("banana")
trie.insert("app")

# Search for words in the Trie
print(trie.search("apple"))  # True
print(trie.search("app"))    # True
print(trie.search("banana")) # True
print(trie.search("orange")) # False

# Check if words start with a prefix
print(trie.starts_with("app")) # True
print(trie.starts_with("ban")) # True
print(trie.starts_with("or"))  # False
