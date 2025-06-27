import time

FILENAME = "confessions.txt"

def encrypt(text, shift=13):
    result = ''
    for char in text:
        if char.isalpha():
            base = ord('A') if char.isupper() else ord('a')
            result += chr((ord(char) - base + shift) % 26 + base)
        else:
            result += char
    return result

def decrypt(text, shift=13):
    return encrypt(text, -shift)

def write_confession():
    print("\nType your confession (press Enter to submit):")
    confession = input("> ")
    encrypted = encrypt(confession)
    with open(FILENAME, "a", encoding="utf-8") as f:
        f.write(encrypted + "\n")
    print("✅ Your secret is safe.")

def read_confessions():
    print("\n--- Your Past Confessions (Decrypted) ---")
    try:
        with open(FILENAME, "r", encoding="utf-8") as f:
            for line in f:
                print("- " + decrypt(line.strip()))
    except FileNotFoundError:
        print("No confessions found yet.")

def main():
    print("🔐 Welcome to Terminal Confession Booth")
    while True:
        print("\n1. Confess")
        print("2. View past confessions")
        print("3. Exit")
        choice = input("Choose an option: ")
        if choice == "1":
            write_confession()
        elif choice == "2":
            read_confessions()
        elif choice == "3":
            print("Leaving the booth... stay strong.")
            break
        else:
            print("Invalid choice.")

if __name__ == "__main__":
    main()
