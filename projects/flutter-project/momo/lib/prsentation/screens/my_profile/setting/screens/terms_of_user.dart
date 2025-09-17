import 'package:flutter/material.dart';
import 'package:momo/core/util/constants/constants.dart';
import 'package:momo/core/util/constants/text_style.dart';

class TermsOfUser extends StatelessWidget {
  List<Map<String, String>> termsList = [
    {
      Constants.title: "1. Changes to These Terms",
      Constants.details:
          "We may update these Terms from time to time. We will notify you of any material changes by posting the updated Terms in the App or via email. Your continued use of the App after the effective date of the changes constitutes your acceptance of the revised Terms. It is your responsibility to review these Terms periodically.",
    },
    {
      Constants.title: "2. User Accounts",
      Constants.details:
          "To access certain features of the App, such as saving edits or sharing content, you may need to create an account. You agree to provide accurate, current, and complete information during registration and to update such information as needed. You are responsible for maintaining the confidentiality of your account credentials (e.g., username and password) and for all activities that occur under your account. You must notify us immediately of any unauthorized use or security breach. We reserve the right to suspend or terminate your account at any time if we suspect misuse, violation of these Terms, or for any other reason, without prior notice.",
    },
    {
      Constants.title: "3. User Content",
      Constants.details:
          "The App allows you to upload, edit, store, and share photos, images, and other content ('User Content'). You retain all rights and ownership in your User Content. By uploading User Content, you grant us a non-exclusive, worldwide, royalty-free, sublicensable license to host, reproduce, modify (for editing purposes), distribute, publicly display, and perform your User Content solely to provide and improve the App's services (e.g., applying filters, enabling sharing, or generating thumbnails). You represent and warrant that: you own or have the necessary rights to your User Content; your User Content does not infringe on any third-party rights, including intellectual property, privacy, or publicity rights; your User Content complies with all applicable laws. We do not claim ownership of your User Content, but we may use anonymized data derived from it to improve the App (e.g., for AI training, if applicable, with your opt-in consent). You can delete your User Content at any time, but copies may remain in backups for a reasonable period. We are not responsible for User Content posted by others. If you believe any User Content violates your rights, contact us at support@photoeditapp.com for review.",
    },
    {
      Constants.title: "4. Intellectual Property",
      Constants.details:
          "The App, including its software, features, designs, trademarks, and copyrights, is owned by us or our licensors and is protected by intellectual property laws. We grant you a limited, non-exclusive, revocable, non-transferable license to use the App for personal, non-commercial purposes. You may not: copy, modify, reverse engineer, or distribute the App or its components; use our trademarks or logos without permission; create derivative works based on the App. Any feedback or suggestions you provide about the App become our property, and we may use them without compensation.",
    },
    {
      Constants.title: "5. Prohibited Conduct",
      Constants.details:
          "You agree not to use the App to: upload or share illegal, harmful, obscene, defamatory, or infringing content; harass, threaten, or impersonate others; introduce viruses, malware, or other harmful code; engage in commercial activities without our consent (e.g., spamming or advertising); violate any laws or third-party rights; automate access to the App (e.g., scraping or bots). We may monitor User Content and remove any that violates these Terms, without liability.",
    },
    {
      Constants.title: "6. Privacy",
      Constants.details:
          "Your use of the App is also governed by our Privacy Policy, which explains how we collect, use, and protect your personal information, including data from uploaded photos (e.g., metadata). By using the App, you consent to our Privacy Policy. We may collect device information, usage data, and location (with your permission) to enhance the App. We do not sell your personal data but may share it with service providers for operational purposes.",
    },
    {
      Constants.title: "7. Subscriptions and Payments",
      Constants.details:
          "Certain premium features may require a subscription. Subscriptions are billed in advance and are non-refundable, except as required by law. We may change pricing with notice. You authorize us to charge your payment method for recurring fees. Cancel your subscription anytime through your account settings; access to premium features ends at the billing period's close.",
    },
    {
      Constants.title: "8. Limitation of Liability",
      Constants.details:
          "To the fullest extent permitted by law, we are not liable for any indirect, incidental, special, or consequential damages arising from your use of the App, including loss of data, profits, or User Content. Our total liability shall not exceed the amount you paid us in the past 12 months. The App is provided 'as is' without warranties of any kind, express or implied.",
    },
    {
      Constants.title: "9. Indemnification",
      Constants.details:
          "You agree to indemnify and hold us harmless from any claims, losses, or damages arising from your violation of these Terms, your User Content, or your use of the App.",
    },
    {
      Constants.title: "10. Termination",
      Constants.details:
          "We may terminate or suspend your access to the App at any time, without notice, for any reason, including violation of these Terms. Upon termination, your license to use the App ends, and you must delete all copies.",
    },
    {
      Constants.title: "11. Governing Law",
      Constants.details:
          "These Terms are governed by the laws of the State of California, USA, without regard to conflict of laws principles. Any disputes shall be resolved in the courts of San Francisco, California.",
    },
    {
      Constants.title: "12. Miscellaneous",
      Constants.details:
          "If any provision of these Terms is unenforceable, the remaining provisions remain in effect. Our failure to enforce any right does not waive it. These Terms constitute the entire agreement between you and us regarding the App.",
    },
    {
      Constants.title: "13. Contact Us",
      Constants.details:
          "For questions about these Terms, contact us at: Email: support@photoeditapp.com; Address: PhotoEdit Inc., 123 Edit Lane, San Francisco, CA 94105, USA.",
    },
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
        title: Text("Terms of Use"),
      ),
      body: Column(
        children: [
          Row(
            children: [
              Expanded(
                child: Text(
                  "MOMO",
                  style: getTitleStyle().copyWith(
                    fontWeight: FontWeight.w800,
                    fontSize: 26,
                  ),
                ),
              ),
              Container(
                padding: EdgeInsets.all(10),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(20),
                ),
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [Text("Try Momo"), Icon(Icons.star_half_sharp)],
                ),
              ),
            ],
          ),
          Divider(),

          Expanded(
            child: ListView.builder(
              itemCount: termsList.length,
              itemBuilder: (context, index) {
                return getTerms(
                  title: termsList[index][Constants.title]!,
                  details: termsList[index][Constants.details]!,
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}

Widget getTerms({required String title, required String details}) {
  return Column(
    crossAxisAlignment: CrossAxisAlignment.start,
    children: [
      Text(title, style: getTitleStyle().copyWith(fontSize: 26)),
      Text(
        details,
        style: getSubtitleStyle().copyWith(
          fontSize: 16,
          fontWeight: FontWeight.normal,
        ),
      ),
      SizedBox(height: 30),
    ],
  );
}
