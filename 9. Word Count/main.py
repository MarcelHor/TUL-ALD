import sys
from collections import defaultdict

def get_frequency(words):
    for word in words:
        if word in dictionary_words:
            dictionary_words[word] += 1
        else:
            dictionary_words[word] = 1
    return dictionary_words

text_input = ""
words = []
dictionary_words = defaultdict()

for line in sys.stdin:
    line = line.strip()
    if not line:
        continue
    text_input += f'{line} '

text_input = text_input.strip()
words = text_input.lower().split(" ")
dictionary_words = get_frequency(words)
print("Word Frequency:")

for key, value in sorted(dictionary_words.items(), key=lambda x: x[1], reverse=True)[:15]:
    freq = value * 100 / len(words)
    print(f" - {key:12} {freq:.2f}% ({value})")
for i in range(len(words) - 1):
    words[i] = words[i] + " " + words[i + 1]

dictionary_words.clear()
dictionary_words = get_frequency(words)
print("Phrase Frequency:")

for key, value in sorted(dictionary_words.items(), key=lambda x: x[1], reverse=True)[:15]:
    freq = value * 100 / len(words)
    print(f" - {key:20} {freq:.2f}% ({value})")
